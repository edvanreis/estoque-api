package com.estoqueapi.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.dto.LojaDTO;
import com.estoqueapi.dto.ResponseMessageDTO;
import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.service.ProductDeliverySevice;

import lombok.AllArgsConstructor;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3870605823789433847L;
	
	@Autowired
	private  EstoqueService service;
	
	@Autowired
	private ProductDeliverySevice productDeliverySevice;

	
	@PostMapping
	public ResponseEntity<ResponseMessageDTO> save(@Validated @RequestBody EstoqueDTO estoque){
		try {
			this.service.save(estoque);
			return ResponseEntity.ok().body(new ResponseMessageDTO(200, "Dados salvos com sucesso!"));
		} catch (EstoqueApiException ex) {
			throw new EstoqueApiException(ex.getMessage());
		}
	}
	
	@GetMapping("{product}/{qtdStore}/store")
	public ResponseEntity<List<LojaDTO>> getInventoryByStore(@PathVariable String product,@PathVariable  Integer qtdStore) {
		try {
			return ResponseEntity.ok().body(this.productDeliverySevice.getInventoryByStore(product,qtdStore));
		} catch (Exception ex) {
			throw new EstoqueApiException(ex.getMessage());
		}
	}

}
