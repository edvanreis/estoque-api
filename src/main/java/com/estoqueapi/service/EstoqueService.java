package com.estoqueapi.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.model.Estoque;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
public interface EstoqueService {

	public void saveList(EstoqueDTO dto);


	public EstoqueDTO save(EstoqueDTO dto);
	
	public void update(EstoqueDTO dto);
	
	public void remove(String id);
	
	public List<EstoqueDTO> findAll();
	
	public void validateAndSave(EstoqueDTO dto, String file);
	
	public List<Estoque> findByProduct(String product);
	
	public Optional<Estoque> findByProductAndPriceAndQuantity(String product, BigDecimal price, Long quantity);

}
