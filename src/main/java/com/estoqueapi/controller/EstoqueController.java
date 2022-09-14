package com.estoqueapi.controller;

import java.util.List;

import com.estoqueapi.dto.ProdutosDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

@CrossOrigin(origins = "*", allowedHeaders = "*") 
@AllArgsConstructor 
@RestController
@RequestMapping(value = "/estoque")
public class EstoqueController {

	
	private final EstoqueService service;
	
	private final ProductDeliverySevice productDeliverySevice;
	
	private final MessageSource messageSource;

	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = ""),
			@ApiResponse(responseCode = "400", description = "Invalid parameters"),
			@ApiResponse(responseCode = "404", description = "not found"),
			@ApiResponse(responseCode = "500", description = "Failure")
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<EstoqueDTO> save(@Validated @RequestBody EstoqueDTO estoque){
		try {
			return ResponseEntity.ok().body(this.service.save(estoque));
		} catch (Exception ex) {
			throw new EstoqueApiException(ex.getMessage());
		}
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = ""),
			@ApiResponse(responseCode = "400", description = "Invalid parameters"),
			@ApiResponse(responseCode = "404", description = "not found"),
			@ApiResponse(responseCode = "500", description = "Failure")
	})
	@PostMapping("saveAll")
	public ResponseEntity<ResponseMessageDTO> saveAll(@Validated @RequestBody ProdutosDTO produtos){
		try {
			this.service.saveAll(produtos);
			return ResponseEntity.ok().body(
					new ResponseMessageDTO(HttpStatus.OK.value(), "Produtos salvos com sucesso!"));
		} catch (EstoqueApiException ex) {
			throw new EstoqueApiException(ex.getMessage());
		}
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = ""),
			@ApiResponse(responseCode = "400", description = "Invalid parameters"),
			@ApiResponse(responseCode = "404", description = "not found"),
			@ApiResponse(responseCode = "500", description = "Failure")
	})
	@GetMapping("/{product}/{qtdStore}/store")
	public ResponseEntity<List<LojaDTO>> getInventoryByStore(@PathVariable String product,@PathVariable  Integer qtdStore) {
		try {
			return ResponseEntity.ok().body(this.productDeliverySevice.getInventoryByStore(product,qtdStore));
		} catch (Exception ex) {
			throw new EstoqueApiException(ex.getMessage());
		}
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = ""),
			@ApiResponse(responseCode = "400", description = "Invalid parameters"),
			@ApiResponse(responseCode = "404", description = "not found"),
			@ApiResponse(responseCode = "500", description = "Failure")
	})
	@GetMapping
	public ResponseEntity<List<EstoqueDTO>> findAll() {
		try {
			return ResponseEntity.ok().body(this.service.findAll());
		} catch (Exception ex) {
			throw new EstoqueApiException(ex.getMessage());
		}
	}

}
