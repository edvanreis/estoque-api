package com.estoqueapi.service;

import com.estoqueapi.convert.impl.ConvertEstoqueDtoToModel;
import com.estoqueapi.convert.impl.ConvertEstoqueDtoToModelForUpdate;
import com.estoqueapi.convert.impl.ConvertEstoquelToDto;
import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.dto.ProdutosDTO;
import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.mock.Mocks;
import com.estoqueapi.model.Estoque;
import com.estoqueapi.repository.EstoqueRepository;
import com.estoqueapi.service.impl.EstoqueServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

	private static String PRODUCT = "LONE";

	private static BigDecimal VALUE = new BigDecimal("5.83");

	private static Long QUANTITY = 47l;

	private Estoque estoque;

	private EstoqueDTO estoqueDto;

	private List<Estoque> estoqueList;

	private List<EstoqueDTO> estoqueListDto;

	private Optional<Estoque> estoqueOpt;

	private ProdutosDTO produtos;


	@Before
	public void init() {
		estoque = Mocks.createEstoque();
		estoqueList = Arrays.asList(estoque);
		estoqueDto = Mocks.createEstoqueDto();
		estoqueListDto = Arrays.asList(estoqueDto);
		estoqueOpt = Optional.of(estoque);
		produtos = ProdutosDTO.builder().data(Arrays.asList(estoqueDto)).build();
	}

	@Test
	public void when_findByProductReturnOK() {
		when(this.repository.findByProduct(anyString())).thenReturn(estoqueList);
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
		when(this.repository.findAll()).thenReturn(estoqueList);
		when(this.convertModelToDto.convert(Mocks.createEstoque())).thenReturn(estoqueDto);
		this.estoqueService.findAll();
		verify(repository, times(1)).findAll();
		verify(convertModelToDto, times(1)).convert(estoque);
	}

	@Test(expected = EstoqueApiException.class)
	public void when_findByProductDoNotOK() {
		when(this.repository.findAll()).thenReturn(new ArrayList<>());
		this.estoqueService.findAll();
	}

	@Test
	public void when_findByProductAndPriceAndQuantityReturnOK() {
		when(this.repository.findByProductAndPriceAndQuantity(PRODUCT,VALUE,QUANTITY)).thenReturn(estoqueOpt);
		this.estoqueService.findByProductAndPriceAndQuantity(PRODUCT,VALUE,QUANTITY);
		verify(repository, times(1)).findByProductAndPriceAndQuantity(PRODUCT,VALUE,QUANTITY);
	}

	@Test
	public void when_validateAndSaveEstotquePresentReturnOK() {
		when(this.convertDtoToModel.convert(Mocks.createEstoqueDto())).thenReturn(estoque);
		when(this.repository.findByProductAndPriceAndQuantity(PRODUCT,VALUE,QUANTITY)).thenReturn(estoqueOpt);
		when(this.estoqueService.findByProductAndPriceAndQuantity(PRODUCT,VALUE,QUANTITY)).thenReturn(Optional.of(Mocks.createEstoque()));
		this.estoqueService.validateAndSave(Mocks.createEstoqueDto(),null);
		verify(repository, times(1)).findByProductAndPriceAndQuantity(PRODUCT,VALUE,QUANTITY);
	}
	@Test
	public void when_validateAndSaveEstotqueDoNotPresentReturnOK() {
		when(this.convertDtoToModel.convert(Mocks.createEstoqueDto())).thenReturn(estoque);
		when(this.repository.findByProductAndPriceAndQuantity(PRODUCT,VALUE,QUANTITY)).thenReturn(estoqueOpt);
		when(this.estoqueService.findByProductAndPriceAndQuantity(PRODUCT,VALUE,QUANTITY)).thenReturn(Optional.empty());
		this.estoqueService.validateAndSave(Mocks.createEstoqueDto(),null);
		verify(repository, times(1)).findByProductAndPriceAndQuantity(PRODUCT,VALUE,QUANTITY);
	}

	@Test
	public void when_removeReturnOK() {
		var estoque = Mocks.createEstoque();
		when(this.repository.findById(estoque.getId())).thenReturn(estoqueOpt);
		this.estoqueService.remove(estoque.getId());
		verify(repository, times(1)).findById(estoque.getId());
	}

	@Test
	public void when_updateReturnOK() {
		var estoque = Mocks.createEstoque();
		when(this.converterForUpdate.convert(estoque,Mocks.createEstoqueDto())).thenReturn(estoque);
		when(this.repository.findById(estoque.getId())).thenReturn(estoqueOpt);
		when(this.converterForUpdate.convert(estoque,Mocks.createEstoqueDto())).thenReturn(estoque);
		this.estoqueService.update(Mocks.createEstoqueDto());
		verify(repository, times(1)).findById(estoque.getId());
	}

	@Test
	public void when_saveAllReturnOK() {
		this.estoqueService.saveAll(produtos);
	}


	@Test
	public void when_saveReturnOK() {
		when(this.convertDtoToModel.convert(estoqueDto)).thenReturn(estoque);
		when(this.repository.save(estoque)).thenReturn(estoque);
		this.estoqueService.save(estoqueDto);
		verify(repository, times(1)).save(estoque);
	}
	
	
}
