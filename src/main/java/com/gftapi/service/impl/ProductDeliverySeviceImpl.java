package com.gftapi.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gftapi.dto.LojaDTO;
import com.gftapi.dto.ResultDTO;
import com.gftapi.exception.GftApiException;
import com.gftapi.model.Estoque;
import com.gftapi.service.EstoqueService;
import com.gftapi.service.ProductDeliverySevice;
import com.gftapi.util.CoreUtil;

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

	/**
	 * Próposito: recupera as lojas e seus produtos
	 * 
	 * @param qtdLojas
	 * @param produto
	 * @return
	 */
	@Override
	public List<LojaDTO> getInventoryByStore(String product, Integer qtdStore) {
		List<Estoque> produtos = this.estoqueService.findByProduct(product);
		List<LojaDTO> lojas = new ArrayList<>();
		if (CoreUtil.isListNotEmpty(produtos)) {
			int count = 1;
			// cria as lojas
			for (int i = 0; i < qtdStore; i++) {
				LojaDTO loja = new LojaDTO();
				loja.setName("Lojista " + count);
				lojas.add(loja);
				count++;
			}

			boolean inversao = false;
			boolean inversaoAux = false;

			List<Long> quantidades = new ArrayList<>();
			for (LojaDTO loja : lojas) {

				Long qtd = 0l;
				Double qtdVolume = 0d;
				Double mediaPreco = 0d;
				loja.setProtucts(new ArrayList<>());

				for (Estoque produto : produtos) {

					ResultDTO result = preencherProduto(produto, quantidades, lojas, inversao, inversaoAux);

					loja.getProtucts().add(result);

					qtd = qtd + result.getQuantity();
					qtdVolume = qtdVolume + result.getVolume();
					mediaPreco = qtdVolume / qtd;

					loja.setQtde(qtd);
					loja.setFinanceiro(new DecimalFormat("#,##0.00").format(qtdVolume));
					loja.setPrecoMedio(new DecimalFormat("#,##0.00").format(mediaPreco));
				}
			}

		} else {
			throw new GftApiException("Não existe dados para esta pesquisa!");
		}
		return lojas;
	}

	/**
	 * Próposito: preecher os produtos
	 * 
	 * @param qtdLojas
	 * @param produto
	 * @return
	 */
	public ResultDTO preencherProduto(Estoque produto, List<Long> quantidades, List<LojaDTO> lojas, boolean inversao,
			boolean inversaoAux) {
		ResultDTO result = new ResultDTO();

		if (produto.getQuantity() % 2 == 0) {
			result.setQuantity(produto.getQuantity() / lojas.size());
		} else {
			if (!quantidades.contains(produto.getQuantity())) {
				quantidades.add(produto.getQuantity());
				if (inversao) {
					result.setQuantity((produto.getQuantity() / lojas.size()) + 1);
				} else {
					result.setQuantity(produto.getQuantity() / lojas.size());
					inversao = true;
				}
			} else {
				if (!inversaoAux) {
					result.setQuantity((produto.getQuantity() / lojas.size()) + 1);
					inversaoAux = true;
				} else {
					result.setQuantity(produto.getQuantity() / lojas.size());
				}
			}
			quantidades.add(produto.getQuantity());
		}

		result.setPrice(produto.getPrice());
		result.setVolume(produto.getPrice().multiply(new BigDecimal(result.getQuantity())).doubleValue());
		result.setProduct(produto.getProduct());

		return result;
	}

}
