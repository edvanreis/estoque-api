package com.gftapi.dto;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
public class ResponseMessageDTO {

	private Integer codigo;
	private String value;

	public ResponseMessageDTO(Integer codigo, String value) {
		this.codigo = codigo;
		this.value = value;
	}
	
	/********************************************************************************************
	 * Get Set
	 ********************************************************************************************/

	/**
	 * Recupera o atributo 'codigo'
	 * 
	 * @return
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * preenche o atributo 'id'
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	/**
	 * Recupera o atributo 'value'
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * preenche o atributo 'value'
	 */
	public void setValue(String value) {
		this.value = value;
	}


}
