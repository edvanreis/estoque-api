package com.estoqueapi.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.estoqueapi.dto.LojaDTO;
import com.estoqueapi.dto.ResultDTO;
import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.model.Estoque;
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.service.ProductDeliverySevice;
import com.estoqueapi.util.CoreUtil;

import lombok.AllArgsConstructor;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class ProductDeliverySeviceImpl implements ProductDeliverySevice {

	private EstoqueService estoqueService;
	
	private final MessageSource messageSource;
	
	private static final String LOJA_NAME = "Lojista ";

	/**
	 * Próposito: recupera as lojas e seus produtos
	 * 
	 * @param qtdLojas
	 * @param produto
	 * @return
	 */
	@Override
	public List<LojaDTO> getInventoryByStore(String product,Integer qtdStore) {
		var produtos = this.estoqueService.findByProduct(product.toUpperCase());

		if (CoreUtil.isListNotEmpty(produtos)) {
			List<LojaDTO> lojas = new ArrayList<>();
			lojas.addAll(createStore(qtdStore));
			lojas = setProduct(qtdStore, produtos, lojas);
			return lojas;

		}
		throw new EstoqueApiException("Não existem dados para esta pesquisa!");
	}
	
	/**
	 * Próposito: criar lojas 
	 * @param qtdStore
	 * @return
	 */
	private List<LojaDTO> createStore(Integer qtdStore) {
		List<LojaDTO> lojas = new ArrayList<>();
		int count = 1;
		for (int i = 0; i < qtdStore; i++) {
			var loja = new LojaDTO();
			loja.setName(LOJA_NAME + count);
			lojas.add(loja);
			count++;
		}
		return lojas;
	}

	/**
	 * Próposito: adicionar os produtos a loja
	 * @param qtdStore
	 * @param produtos
	 * @param lojas
	 * @return
	 */

	private List<LojaDTO> setProduct(Integer qtdStore, List<Estoque> produtos, List<LojaDTO> lojas) {
		
		
		boolean inversao = false;
		boolean inversaoAux = false;
		
		List<Long>quantidades = new ArrayList<>();
		
		if(lojas.size() == 1 ) {
			
			lojas = calcOneStore(produtos, lojas);
			
		}else {
			for (LojaDTO loja : lojas) {
				
				Long qtd = 0l;
				Double qtdVolume = 0d; 
				Double mediaPreco = 0d; 
				loja.setProtucts(new ArrayList<>());
				
				for (Estoque produto : produtos) {
					
					var result = new ResultDTO();
					
					if(produto.getQuantity()%2==0) {
						result.setQuantity(produto.getQuantity()/lojas.size());
					}else {
						if(!quantidades.contains(produto.getQuantity())) {
							quantidades.add(produto.getQuantity());
							if(inversao) {
								result.setQuantity((produto.getQuantity()/lojas.size())+1);
							}else {
								result.setQuantity(produto.getQuantity()/lojas.size());
								inversao = true;
							}
						}else {
							if(!inversaoAux) {
								result.setQuantity((produto.getQuantity()/lojas.size())+1);
								inversaoAux = true;
							}else {
								result.setQuantity(produto.getQuantity()/lojas.size());
							}
						}
						quantidades.add(produto.getQuantity());
					}

					var price = produto.getPrice().replace("$","");

					result.setPrice(new DecimalFormat("#,##0.00").format(new BigDecimal(price)));
					result.setProduct(produto.getProduct());
					result.setVolume(new DecimalFormat("#,##0.00")
							        .format(new BigDecimal(price).multiply(new BigDecimal(result.getQuantity()))
									.doubleValue()));
					loja.getProtucts().add(result);
				    
					qtd=qtd+result.getQuantity();
					qtdVolume=qtdVolume+Double.valueOf(result.getVolume().replace(",",".")); 
					mediaPreco = qtdVolume/qtd;
					
					loja.setQtde(qtd);
					loja.setFinanceiro(new DecimalFormat("#,##0.00").format(qtdVolume)); 
					loja.setPrecoMedio(new DecimalFormat("#,##0.00").format(mediaPreco));
				}
			}
		}
		
		return lojas;
	}

	/***
	 * Adiciona produtos apenas em uma unica loja
	 * @param produtos
	 * @param lojas
	 * @return
	 */
	private List<LojaDTO> calcOneStore(List<Estoque> produtos, List<LojaDTO> lojas) {
		for (LojaDTO loja : lojas) {

			Long qtd = 0l;
			Double qtdVolume = 0d;
			Double mediaPreco = 0d;
			loja.setProtucts(new ArrayList<>());

			for (Estoque produto : produtos) {

				ResultDTO result = new ResultDTO();
				result.setQuantity(produto.getQuantity());
				var price = produto.getPrice().replace("$","");
				result.setPrice(new DecimalFormat("#,##0.00").format(new BigDecimal(price)));
				result.setProduct(produto.getProduct());
				result.setVolume(new DecimalFormat("#,##0.00")
						.format(new BigDecimal(price).multiply(new BigDecimal(result.getQuantity())).doubleValue()));
				loja.getProtucts().add(result);

				qtd = qtd + result.getQuantity();
				qtdVolume = qtdVolume + Double.valueOf(result.getVolume().replace(",", "."));
				mediaPreco = qtdVolume / qtd;

				loja.setQtde(qtd);
				loja.setFinanceiro(new DecimalFormat("#,##0.00").format(qtdVolume));
				loja.setPrecoMedio(new DecimalFormat("#,##0.00").format(mediaPreco));
			}
		}
		return lojas;
	}


}
