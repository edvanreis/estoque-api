package com.estoqueapi.dto;

import lombok.*;

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
@AllArgsConstructor
@RequiredArgsConstructor
public class LojaDTO implements Serializable {
	
	private String name;
	private List<ResultDTO>protucts;
	private Long qtde;
	private String financeiro;
	private String precoMedio;
	


}
