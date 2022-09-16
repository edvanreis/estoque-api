package com.estoqueapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * Data de Criação:15/09/2022
 * @author endr
 * @version 1.0
 */

@Builder
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class TypeDTO implements Serializable {

	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;


}
