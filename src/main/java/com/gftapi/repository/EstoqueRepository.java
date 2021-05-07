package com.gftapi.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gftapi.model.Estoque;


/**
 * Data de Criação:05/05/2021
 * @author endr
 * @version 1.0
 */
public interface EstoqueRepository extends CrudRepository<Estoque,Long>{

	Optional<Estoque> findByProductAndPriceAndQuantity(String product,BigDecimal price,Long quantity);

	List<Estoque> findByProduct(String product);
}
