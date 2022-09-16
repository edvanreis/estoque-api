package com.estoqueapi.repository;

import com.estoqueapi.model.Estoque;
import com.estoqueapi.model.Type;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


/**
 * Data de Criação:15/09/2022
 * @author endr
 * @version 1.0
 */
@Repository
public interface TypeRepository extends MongoRepository<Type, String> {




}
