package com.estoqueapi.service.impl;

import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.dto.ProdutosDTO;
import com.estoqueapi.dto.TypeDTO;
import com.estoqueapi.model.Estoque;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
public interface TypeService {
	
	public List<TypeDTO> findAll();


}
