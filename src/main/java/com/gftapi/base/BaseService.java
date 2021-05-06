package com.gftapi.base;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

//import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

/**
 * Classe Abstrata para reuso de métodos do service
 * @param <T>
 * Data de Criação:05/05/2021
 * @author endr
 * @version 1.0
 */
public abstract class BaseService<T extends BaseModel> extends AbstractBase {

	@Autowired
	protected HttpServletRequest request;
	
	private String orderColumn = "id";
    private Sort.Direction order = Sort.Direction.ASC;

	protected MyCrudRepository<T> repository;

	protected BaseService(MyCrudRepository<T> repository) {
		this.repository = repository;
	}


	/**
	 * Obtem uma lista de Objetos
	 *
	 * @return T Collection
	 */
	public Iterable<T> getList() {
		return this.repository.findAll();
	}

	/**
	 * Persiste o objeto no banco de dados
	 *
	 * @param object
	 * @return T
	 */
	public T save(T object) {
		return repository.save(object);
	}

	/**
	 * remove o objeto direto do banco
	 * 
	 * @param object
	 */
	public void remove(T object) {
		repository.delete(object);
	}

	/**
	 * remove o objeto direto do banco
	 * 
	 * @param object
	 */
	public void removeById(Long id) {
		repository.deleteById(id);
	}

	/**
	 * Obtem o objeto pelo id informado
	 *
	 * @param id
	 * @return T
	 */
	public Optional<T> findById(Long id) {
		return this.repository.findById(id);
	}

	/**
	 * Atualiza o Objeto passado
	 *
	 * @param object
	 * @return T
	 */
	public T update(T object) {
		return repository.save(object);
	}
	
	public void setOrder(Sort.Direction direction, String orderColumn) {
		this.order = direction;
		this.orderColumn = orderColumn;
	}

}
