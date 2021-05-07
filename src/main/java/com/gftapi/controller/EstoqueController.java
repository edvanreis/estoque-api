package com.gftapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gftapi.dto.EstoqueDTO;
import com.gftapi.dto.LojaDTO;
import com.gftapi.dto.ResponseMessageDTO;
import com.gftapi.exception.GftApiException;
import com.gftapi.service.EstoqueService;
import com.gftapi.service.ProductDeliverySevice;

import lombok.AllArgsConstructor;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
@AllArgsConstructor
@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3870605823789433847L;
	
	private final EstoqueService service;
	
	private final ProductDeliverySevice productDeliverySevice;

	
	@PostMapping
	public ResponseEntity<ResponseMessageDTO> save(@RequestBody EstoqueDTO estoque){
		try {
			this.service.save(estoque);
			return ResponseEntity.ok().body(new ResponseMessageDTO(200, "Dados salvos com sucesso!"));
		} catch (GftApiException ex) {
			throw new GftApiException(ex.getMessage());
		}
	}
	
	@GetMapping("{product}/{qtdStory}/store")
	public ResponseEntity<List<LojaDTO>> getInventoryByStore(@PathVariable(value = "product") String product,
															 @PathVariable(value = "qtdStory") Integer qtdStory) {
		try {
			return Optional.ofNullable(this.productDeliverySevice.getInventoryByStore(product,qtdStory))
					.map(obj -> new ResponseEntity<>(obj, HttpStatus.OK))
					.orElseThrow(() -> new GftApiException("Erro ao obter dados!"));
		} catch (GftApiException ex) {
			throw new GftApiException(ex.getMessage());
		}
	}

}
