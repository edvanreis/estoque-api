package com.estoqueapi.controller;

import com.estoqueapi.dto.*;
import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.service.ProductDeliverySevice;
import com.estoqueapi.service.impl.TypeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Data de Criação:15/09/2022
 * 
 * @author endr
 * @version 1.0
 */

@CrossOrigin(origins = "*", allowedHeaders = "*") 
@AllArgsConstructor 
@RestController
@RequestMapping(value = "/type")
public class TypeController {
	
	private final TypeService service;

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = ""),
			@ApiResponse(responseCode = "400", description = "Invalid parameters"),
			@ApiResponse(responseCode = "404", description = "not found"),
			@ApiResponse(responseCode = "500", description = "Failure")
	})
	@GetMapping
	public ResponseEntity<List<TypeDTO>> findAll() {
		try {
			return ResponseEntity.ok().body(this.service.findAll());
		} catch (Exception ex) {
			throw new EstoqueApiException(ex.getMessage());
		}
	}

}
