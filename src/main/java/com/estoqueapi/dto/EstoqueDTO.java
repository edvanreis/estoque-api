package com.estoqueapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Data de Criação:05/05/2021
 * Atualizado: 08/09/2021
 * @author endr
 * @version 1.2
 */
@Builder
@Setter
@Getter
public class EstoqueDTO implements Serializable {

	@JsonProperty("id")
	private String id;
	@JsonProperty("product")
	private String product;
	@JsonProperty("quantity")
	private Long quantity;
	@JsonProperty("price")
	private String price;
	@JsonProperty("type")
	private String type;
	@JsonProperty("industry")
	private String industry;
	@JsonProperty("origin")
	private String origin;
	private String file;

	


}
