package com.estoqueapi.dto;

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
	
	private String name;
	private List<ResultDTO>protucts;
	private Long qtde;
	private String financeiro;
	private String precoMedio;
	
	public LojaDTO() {
		super();
	}
	

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
	public List<ResultDTO> getProtucts() {
		return protucts;
	}

	/**
	 * preenche o atributo 'protucts'
	 */
	public void setProtucts(List<ResultDTO> protucts) {
		this.protucts = protucts;
	}

	/**
	 * Recupera o atributo 'qtde'
	 * 
	 * @return
	 */
	public Long getQtde() {
		return qtde;
	}

	/**
	 * preenche o atributo 'qtde'
	 */
	public void setQtde(Long qtde) {
		this.qtde = qtde;
	}
	
	/**
	 * Recupera o atributo 'financeiro'
	 * 
	 * @return
	 */
	public String getFinanceiro() {
		return financeiro;
	}

	/**
	 * preenche o atributo 'financeiro'
	 */
	public void setFinanceiro(String financeiro) {
		this.financeiro = financeiro;
	}

	/**
	 * Recupera o atributo 'precoMedio'
	 * 
	 * @return
	 */
	public String getPrecoMedio() {
		return precoMedio;
	}

	/**
	 * preenche o atributo 'precoMedio'
	 */
	public void setPrecoMedio(String precoMedio) {
		this.precoMedio = precoMedio;
	}



}
