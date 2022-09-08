package com.estoqueapi.service;

import com.estoqueapi.convert.impl.ConvertEstoqueDtoToModel;
import com.estoqueapi.convert.impl.ConvertEstoqueDtoToModelForUpdate;
import com.estoqueapi.convert.impl.ConvertEstoquelToDto;
import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.mock.Mocks;
import com.estoqueapi.repository.EstoqueRepository;
import com.estoqueapi.service.impl.EstoqueServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

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

	@Mock
	private ConvertEstoqueDtoToModel convertDtoToModel;

	@Mock
	private ConvertEstoqueDtoToModelForUpdate converterForUpdate;

	
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
	public void when_findByAllReturnOK() {
		when(this.repository.findAll()).thenReturn(Arrays.asList(Mocks.createEstoque()));
		when(this.convertModelToDto.convert(Mocks.createEstoque())).thenReturn(Mocks.createEstoqueDto());
		this.estoqueService.findAll();
		verify(repository, times(1)).findAll();
		verify(convertModelToDto, times(1)).convert(Mocks.createEstoque());
	}

	@Test(expected = EstoqueApiException.class)
	public void when_findByProductNotDoNotOK() {
		when(this.repository.findAll()).thenReturn(new ArrayList<>());
		this.estoqueService.findAll();
	}

	@Test
	public void when_findByProductAndPriceAndQuantityReturnOK() {
		when(this.repository.findByProductAndPriceAndQuantity("LONE",new BigDecimal("5.83"),47l)).thenReturn(Optional.of(Mocks.createEstoque()));
		this.estoqueService.findByProductAndPriceAndQuantity("LONE",new BigDecimal("5.83"),47l);
		verify(repository, times(1)).findByProductAndPriceAndQuantity("LONE",new BigDecimal("5.83"),47l);
	}

	@Test
	public void when_validateAndSaveEstotquePresentReturnOK() {
		when(this.convertDtoToModel.convert(Mocks.createEstoqueDto())).thenReturn(Mocks.createEstoque());
		when(this.repository.findByProductAndPriceAndQuantity("LONE",new BigDecimal("5.83"),47l)).thenReturn(Optional.of(Mocks.createEstoque()));
		when(this.estoqueService.findByProductAndPriceAndQuantity("LONE",new BigDecimal("5.83"),47l)).thenReturn(Optional.of(Mocks.createEstoque()));
		this.estoqueService.validateAndSave(Mocks.createEstoqueDto(),null);
		verify(repository, times(1)).findByProductAndPriceAndQuantity("LONE",new BigDecimal("5.83"),47l);
	}
	@Test
	public void when_validateAndSaveEstotqueDoNotPresentReturnOK() {
		when(this.convertDtoToModel.convert(Mocks.createEstoqueDto())).thenReturn(Mocks.createEstoque());
		when(this.repository.findByProductAndPriceAndQuantity("LONE",new BigDecimal("5.83"),47l)).thenReturn(Optional.of(Mocks.createEstoque()));
		when(this.estoqueService.findByProductAndPriceAndQuantity("LONE",new BigDecimal("5.83"),47l)).thenReturn(Optional.empty());
		this.estoqueService.validateAndSave(Mocks.createEstoqueDto(),null);
		verify(repository, times(1)).findByProductAndPriceAndQuantity("LONE",new BigDecimal("5.83"),47l);
	}

	@Test
	public void when_removeReturnOK() {
		var estoque = Mocks.createEstoque();
		when(this.repository.findById(estoque.getId())).thenReturn(Optional.of(Mocks.createEstoque()));
		this.estoqueService.remove(estoque.getId());
		verify(repository, times(1)).findById(estoque.getId());
	}

	@Test
	public void when_updateReturnOK() {
		var estoque = Mocks.createEstoque();
		when(this.converterForUpdate.convert(estoque,Mocks.createEstoqueDto())).thenReturn(Mocks.createEstoque());
		when(this.repository.findById(estoque.getId())).thenReturn(Optional.of(Mocks.createEstoque()));
		when(this.converterForUpdate.convert(estoque,Mocks.createEstoqueDto())).thenReturn(Mocks.createEstoque());
		this.estoqueService.update(Mocks.createEstoqueDto());
		verify(repository, times(1)).findById(estoque.getId());
	}

	@Test
	public void when_saveReturnOK() {
		var estoque = Mocks.createEstoqueDto();
		estoque.setData(Arrays.asList(Mocks.createEstoqueDto()));
		this.estoqueService.save(estoque);
	}

	@Test
	public void when_saveDoNotDataReturnOK() {
		var estoque = Mocks.createEstoqueDto();
		this.estoqueService.save(estoque);
	}
	
	
}
