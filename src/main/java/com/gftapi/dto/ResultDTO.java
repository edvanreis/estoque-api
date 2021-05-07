package com.gftapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
@Builder
public class ResultDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7917804577910109160L;


	private String product;
	private Long quantity;
	private BigDecimal price;
	private Double volume;
	
	public ResultDTO() {
		super();
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
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * preenche o atributo 'price'
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Recupera o atributo 'volume'
	 * 
	 * @return
	 */
	public Double getVolume() {
		return volume;
	}

	/**
	 * preenche o atributo 'volume'
	 */
	public void setVolume(Double volume) {
		this.volume = volume;
	}



}
