package com.estoqueapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Data de Criação:05/05/2021
 * Atualização :06/09/2022
 * @author endr
 * @version 1.0
 */

@Data
@Entity
@Builder
@Document(collection = "estoque")
@AllArgsConstructor
@RequiredArgsConstructor
public class Estoque implements Serializable {


	@Id
	private String id;
	private String product;
	private Long quantity;
	private String price;
	private String type;
	private String industry;
	private String origin;
	private String file;
	@CreationTimestamp
	public LocalDateTime dataCriacao;
	@UpdateTimestamp
	public LocalDateTime dataAtualizacao;


}
