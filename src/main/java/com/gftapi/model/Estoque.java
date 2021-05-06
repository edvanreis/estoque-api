package com.gftapi.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gftapi.base.BaseModel;
import com.sun.istack.NotNull;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
@Entity
@Table(name = "estoque")
public class Estoque extends BaseModel {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -399004998935769088L;

	@NotNull
	private String product;
	private Long quantity;
	private BigDecimal price;
	private String type;
	private String industry;
	private String origin;
	private String file;

	public Estoque() {
		super();
	}

	/********************************************************************************************
	 * Get Set
	 ********************************************************************************************/

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

}
