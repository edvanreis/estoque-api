package com.estoqueapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
@Builder
@Setter
@Getter
public class EstoqueDTO implements Serializable {

	private String id;
	private String product;
	private Long quantity;
	private String price;
	private String type;
	private String industry;
	private String origin;
	private List<EstoqueDTO>data;
	private String file;

	


}
