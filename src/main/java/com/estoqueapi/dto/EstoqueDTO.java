package com.estoqueapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
@Builder
public class EstoqueDTO implements Serializable {

	private static final long serialVersionUID = -5847388722517720147L;

	private Long id;
	private String product;
	private Long quantity;
	private String price;
	private String type;
	private String industry;
	private String origin;
	private List<EstoqueDTO>data;
	private String file;
	private BigDecimal priceDecimal;
	
	/**
	 * Recupera o atributo 'id'
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * preenche o atributo 'id'
	 */
	public void setId(Long id) {
		this.id = id;
	}
	

	/**
	 * Recupera o atributo 'product'
	 * 
	 * @return
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * preenche o atributo 'product'
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * Recupera o atributo 'quantity'
	 * 
	 * @return
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * preenche o atributo 'quantity'
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	/**
	 * Recupera o atributo 'price'
	 * 
	 * @return
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * preenche o atributo 'price'
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * Recupera o atributo 'type'
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * preenche o atributo 'type'
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Recupera o atributo 'industry'
	 * 
	 * @return
	 */
	public String getIndustry() {
		return industry;
	}

	
	/**
	 * preenche o atributo 'industry'
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * Recupera o atributo 'origin'
	 * 
	 * @return
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * preenche o atributo 'origin'
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * Recupera o atributo 'data'
	 * 
	 * @return
	 */
	public List<EstoqueDTO> getData() {
		return data;
	}

	/**
	 * preenche o atributo 'data'
	 */
	public void setData(List<EstoqueDTO> data) {
		this.data = data;
	}
	

	/**
	 * Recupera o atributo 'file'
	 * 
	 * @return
	 */
	public String getFile() {
		return file;
	}

	/**
	 * preenche o atributo 'file'
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * preenche o atributo 'priceDecimal'
	 */
	public BigDecimal getPriceDecimal() {
		return priceDecimal;
	}

	/**
	 * Recupera o atributo 'priceDecimal'
	 * 
	 * @return
	 */
	public void setPriceDecimal(BigDecimal priceDecimal) {
		this.priceDecimal = priceDecimal;
	}


}
