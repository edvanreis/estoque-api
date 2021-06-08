package com.estoqueapi.controller.service.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.repository.EstoqueRepository;
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.service.impl.EstoqueServiceImpl;

@DisplayName("Tests for the EstoqueServiceTest ")
@ExtendWith(SpringExtension.class)
public class EstoqueServiceTest {
	
	@InjectMocks
	private EstoqueServiceImpl estoqueService;
	
	@Mock
	private EstoqueRepository repository;
	
	@Mock
	private  MessageSource messageSource;
	
	@Test
	void when_findByProduct() {
		try {
			when(this.repository.findByProduct("EMS")).thenReturn(new ArrayList<>());
			this.estoqueService.findByProduct("EMS");
		} catch (EstoqueApiException e) {
			Assertions.assertNotNull(e);
		}	
	}

	
	@Test
	void when_findByAll() {
		try {
			when(this.repository.findAll()).thenReturn(new ArrayList<>());
			this.estoqueService.findAll();
		} catch (EstoqueApiException e) {
			Assertions.assertNotNull(e);
		}
		
	}
	
	
}
