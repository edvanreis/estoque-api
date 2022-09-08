package com.estoqueapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.*;

/**
 * Data de Criação:05/05/2021
 * Atualizado: 08/09/2021
 * @author endr
 * @version 1.2
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ResultDTO implements Serializable {


	private String product;
	private Long quantity;
	private String price;
	private String volume;
	


}
