package com.estoqueapi.controller.service.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.repository.EstoqueRepository;
import com.estoqueapi.service.EstoqueService;

@DisplayName("Tests for the EstoqueServiceTest ")
@ExtendWith(SpringExtension.class)
public class EstoqueServiceTest {
	
	@Mock
	private EstoqueService estoqueService;
	
	@Mock
	private EstoqueRepository repository;
	
	@Mock
	private  MessageSource messageSource;
	
	@Test
	void when_findByProduct_RunOK() {
			when(this.repository.findByProduct(Mockito.eq("EMS"))).thenReturn(new ArrayList<>());
			this.estoqueService.findByProduct(Mockito.eq("EMS"));
	}
	
	@Test
	void when_findByProduct_ThrowException() {
		try {
			when(this.estoqueService.findByProduct(Mockito.eq("456"))).thenReturn(new ArrayList<>());
		} catch (EstoqueApiException e) {
			Assertions.assertNotNull(e);
		}
		
	}
	
	@Test
	void findByAll() {
		try {
			Mockito.when(this.estoqueService.findAll()).thenReturn(new ArrayList<>());
		} catch (EstoqueApiException e) {
			Assertions.assertNotNull(e);
		}
		
	}
	
	
}
