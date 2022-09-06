package com.estoqueapi.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.estoqueapi.model.Estoque;
import org.springframework.stereotype.Repository;


/**
 * Data de Criação:05/05/2021
 * Atualização :06/09/2022
 * @author endr
 * @version 1.0
 */
@Repository
public interface EstoqueRepository extends MongoRepository<Estoque, String> {

	Optional<Estoque> findByProductAndPriceAndQuantity(String product,BigDecimal price,Long quantity);

	List<Estoque> findByProduct(String product);


}
