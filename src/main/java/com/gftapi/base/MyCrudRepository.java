package com.gftapi.base;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Data de Criação:05/05/2021
 * @author endr
 * @version 1.0
 */
public interface MyCrudRepository<T extends BaseModel> extends CrudRepository<T, Long>, JpaSpecificationExecutor<T>{
    
}
