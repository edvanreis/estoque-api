package com.estoqueapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Data de Criação:05/05/2021
 * Atualizado: 08/09/2021
 * @author endr
 * @version 1.2
 */
@Builder
@Setter
@Getter
public class ProdutosDTO implements Serializable {

	private List<EstoqueDTO>data;
	private String file;


}
