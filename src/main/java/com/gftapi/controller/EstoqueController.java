package com.gftapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gftapi.base.BaseController;
import com.gftapi.dto.EstoqueDTO;
import com.gftapi.dto.LojaDTO;
import com.gftapi.dto.ResponseMessageDTO;
import com.gftapi.exception.GftApiException;
import com.gftapi.model.Estoque;
import com.gftapi.service.EstoqueService;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
@RestController
@RequestMapping("/estoque")
public class EstoqueController extends BaseController<Estoque, EstoqueDTO> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3870605823789433847L;

	/********************************************************************************************
	 * Atributos
	 ********************************************************************************************/
	private EstoqueService service;


	/********************************************************************************************
	 * Construtor
	 ********************************************************************************************/
	@Autowired
	protected EstoqueController(EstoqueService service) {
		super(service, EstoqueDTO.class);
		this.service = service;
	}
	
	/********************************************************************************************
	 * Métodos
	 ********************************************************************************************/
	
	@PostMapping
	protected ResponseEntity<ResponseMessageDTO> save(@RequestBody EstoqueDTO estoque){
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
			return Optional.ofNullable(this.service.getInventoryByStore(product,qtdStory))
					.map(obj -> new ResponseEntity<>(obj, HttpStatus.OK))
					.orElseThrow(() -> new GftApiException("Erro ao obter dados!"));
		} catch (GftApiException ex) {
			throw new GftApiException(ex.getMessage());
		}
	}

}
