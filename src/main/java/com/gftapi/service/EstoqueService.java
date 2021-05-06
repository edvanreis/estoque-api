package com.gftapi.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gftapi.base.BaseService;
import com.gftapi.dao.EstoqueDAO;
import com.gftapi.dto.EstoqueDTO;
import com.gftapi.dto.LojaDTO;
import com.gftapi.exception.GftApiException;
import com.gftapi.model.Estoque;
import com.gftapi.util.CoreUtil;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
@Service
public class EstoqueService extends BaseService<Estoque> {

	/********************************************************************************************
	 * Atributos
	 ********************************************************************************************/
	private final EstoqueDAO dao;

	/********************************************************************************************
	 * Construtor
	 ********************************************************************************************/
	@Autowired
	public EstoqueService(EstoqueDAO dao) {
		super(dao);
		this.dao = dao;
	}

	/********************************************************************************************
	 * Métodos
	 ********************************************************************************************/

	/***
	 * Próposito:receber e salvar o estoque
	 * 
	 * @param lista
	 */
	@Transactional
	public void save(EstoqueDTO dto) {
		if (CoreUtil.isListNotEmpty(dto.getData())) {
			dto.getData().forEach(i -> validateAndSave(i, dto.getFile()));
		} else {
			validateAndSave(dto, dto.getFile());
		}
	}

	/**
	 * Próposito converter para model
	 * 
	 * @param dto
	 * @return
	 */
	public Estoque dtoToModel(EstoqueDTO dto) {
		Estoque estoque = new Estoque();
		estoque.setProduct(dto.getProduct());
		estoque.setQuantity(dto.getQuantity());
		estoque.setType(dto.getType());
		estoque.setIndustry(dto.getIndustry());
		estoque.setOrigin(dto.getOrigin());
		estoque.setPrice(princeToBigDecimal(dto.getPrice()));
		estoque.setFile(dto.getFile());

		return estoque;
	}

	/**
	 * Próposito converter para model
	 * 
	 * @param dto
	 * @return
	 */
	public EstoqueDTO modelToDto(Estoque estoque) {
		EstoqueDTO dto = new EstoqueDTO();
		dto.setProduct(estoque.getProduct());
		dto.setQuantity(estoque.getQuantity());
		dto.setType(estoque.getType());
		dto.setIndustry(estoque.getIndustry());
		dto.setOrigin(estoque.getOrigin());
		dto.setPrice(princeToString(estoque.getPrice()));
		dto.setPriceDecimal(estoque.getPrice());
		dto.setFile(estoque.getFile());

		return dto;
	}

	/**
	 * Próposito: converter price de string para bigdecimal
	 * 
	 * @param dto
	 * @return
	 */
	public BigDecimal princeToBigDecimal(String price) {
		if (price != null && !price.isEmpty()) {
			price = price.replace("$", "");
			price = price.toString();
			return new BigDecimal(price);
		}
		return null;
	}

	/**
	 * Próposito: converter price de string para bigdecimal
	 * 
	 * @param dto
	 * @return
	 */
	public String princeToString(BigDecimal price) {
		String priceStr = null;
		if (price != null) {
			price = price.setScale(2, RoundingMode.HALF_EVEN);
			priceStr = "$" + price.toString();
		}
		return priceStr;
	}

	/**
	 * Próposito: verificar se produto existe caso não exista salva
	 * 
	 * @param dto
	 * @param file
	 */
	public void validateAndSave(EstoqueDTO dto, String file) {
		BigDecimal price = princeToBigDecimal(dto.getPrice());
		Optional<Estoque> estoqueOpt = findByProductAndPriceAndQuantity(dto.getProduct(), price, dto.getQuantity());
		if (!estoqueOpt.isPresent()) {
			dto.setFile(file);
			super.save(dtoToModel(dto));
		}
	}

	/**
	 * Próposito: recupera as lojas e seus produtos
	 * @param qtdLojas
	 * @param produto
	 * @return
	 */
	public List<LojaDTO> getInventoryByStore(String product,Integer qtdStore) {
		List<Estoque> produtos = findByProduct(product);
		List<LojaDTO> lojas = new ArrayList<>();
		if (CoreUtil.isListNotEmpty(produtos)) {
			int count = 1;
			for (int i = 0; i < qtdStore; i++) {
				LojaDTO loja = new LojaDTO();
				loja.setName("Lojista " + count);
				lojas.add(loja);
				count++;
			}
		}else {
			throw new GftApiException("Não existe dados para esta pesquisa!");
		}
		return lojas;
	}

	/********************************************************************************************
	 * Consultas
	 ********************************************************************************************/
	public Optional<Estoque> findByProductAndPriceAndQuantity(String product, BigDecimal price, Long quantity) {
		return this.dao.findByProductAndPriceAndQuantity(product, price, quantity);
	}

	public List<Estoque> findByProduct(String product) {
		return this.dao.findByProduct(product);
	}

}
