package com.gftapi.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.gftapi.base.MyCrudRepository;
import com.gftapi.model.Estoque;


/**
 * Data de Criação:05/05/2021
 * @author endr
 * @version 1.0
 */
public interface EstoqueDAO extends MyCrudRepository<Estoque>{

	Optional<Estoque> findByProductAndPriceAndQuantity(String product,BigDecimal price,Long quantity);

	List<Estoque> findByProduct(String product);
}
