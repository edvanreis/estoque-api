package com.gftapi.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
public class LojaDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5307865535654315172L;
	
	/********************************************************************************************
	 * Atributos
	 ********************************************************************************************/
	private String name;
	private List<EstoqueDTO>protucts;
	
	public LojaDTO() {
		super();
	}
	
	/********************************************************************************************
	 * Get Set
	 ********************************************************************************************/

	/**
	 * Recupera o atributo 'name'
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * preenche o atributo 'name'
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Recupera o atributo 'protucts'
	 * 
	 * @return
	 */
	public List<EstoqueDTO> getProtucts() {
		return protucts;
	}

	/**
	 * preenche o atributo 'protucts'
	 */
	public void setProtucts(List<EstoqueDTO> protucts) {
		this.protucts = protucts;
	}



}
