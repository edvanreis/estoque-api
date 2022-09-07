package com.estoqueapi.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import com.estoqueapi.convert.impl.ConvertEstoquelToDto;
import com.estoqueapi.mock.Mocks;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.repository.EstoqueRepository;
import com.estoqueapi.service.impl.EstoqueServiceImpl;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@DisplayName("Tests for the EstoqueServiceTest ")
@RunWith(SpringRunner.class)
public class EstoqueServiceTest {
	
	@InjectMocks
	private EstoqueServiceImpl estoqueService;
	
	@Mock
	private EstoqueRepository repository;

	@Mock
	private ConvertEstoquelToDto convertModelToDto;

	
	@Test
	public void when_findByProductReturnOK() {
		when(this.repository.findByProduct(anyString())).thenReturn(Arrays.asList(Mocks.createEstoque()));
		this.estoqueService.findByProduct(anyString());
		verify(repository, times(1)).findByProduct(anyString());
	}

	@Test(expected = EstoqueApiException.class)
	public void when_findByProductNotReturnOK() {
		when(this.repository.findByProduct(anyString())).thenReturn(new ArrayList<>());
		this.estoqueService.findByProduct(anyString());
	}



	@Test
	public void when_findByAll() {
		when(this.repository.findAll()).thenReturn(Arrays.asList(Mocks.createEstoque()));
		when(this.convertModelToDto.converter(Mocks.createEstoque())).thenReturn(Mocks.createEstoqueDto());
		this.estoqueService.findAll();
		verify(repository, times(1)).findAll();
		verify(convertModelToDto, times(1)).converter(Mocks.createEstoque());
	}
	
	
}
