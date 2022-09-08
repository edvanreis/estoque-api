package com.estoqueapi.dto;

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
public class ResponseMessageDTO {

	private Integer codigo;
	private String value;


}
