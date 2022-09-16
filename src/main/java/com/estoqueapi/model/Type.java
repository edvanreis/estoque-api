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
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Data de Criação:15/09/2022
 * @author endr
 * @version 1.0
 */

@Data
@Entity
@Builder
@Document(collection = "type")
@AllArgsConstructor
@RequiredArgsConstructor
public class Type implements Serializable {


	@Id
	private String id;
	private String name;


}
