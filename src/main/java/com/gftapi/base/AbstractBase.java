package com.gftapi.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Data de Criação:05/05/2021
 * @author endr
 * @version 1.0
 */
public abstract class AbstractBase {

	@PersistenceContext
	protected EntityManager entityManager;

	@Autowired
	protected HttpServletRequest request;

}
