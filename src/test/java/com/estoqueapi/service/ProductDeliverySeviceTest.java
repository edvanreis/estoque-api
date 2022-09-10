package com.estoqueapi.service;

import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.mock.Mocks;
import com.estoqueapi.model.Estoque;
import com.estoqueapi.service.impl.ProductDeliverySeviceImpl;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@DisplayName("Tests for the ProductDeliverySeviceTest ")
@RunWith(SpringRunner.class)
public class ProductDeliverySeviceTest {

	@InjectMocks
	private ProductDeliverySeviceImpl productDeliverySevice;
	
	@Mock
	private EstoqueService repository;

	private static String PRODUCT = "LONE";

	private static Integer QUANTIDADE = 2;

	private Estoque estoque;

	private List<Estoque> estoqueList;


	@Before
	public void init() {
		estoque = Mocks.createEstoque();
		estoqueList = Arrays.asList(estoque);
	}
	
	
	@Test
	public void when_getInventoryByStoreSizeTwoReturnOK() {
		when(this.repository.findByProduct(PRODUCT)).thenReturn(estoqueList);
		this.productDeliverySevice.getInventoryByStore(PRODUCT,QUANTIDADE);
		verify(repository, times(1)).findByProduct(PRODUCT);
	}

	@Test
	public void when_getInventoryByStoreOneReturnOK() {
		when(this.repository.findByProduct(PRODUCT)).thenReturn(Arrays.asList(estoque));
		this.productDeliverySevice.getInventoryByStore(PRODUCT,QUANTIDADE);
		verify(repository, times(1)).findByProduct(PRODUCT);
	}

	@Test(expected = EstoqueApiException.class)
	public void when_getInventoryByStoreDoNotReturnOK() {
		when(this.repository.findByProduct(PRODUCT)).thenReturn(new ArrayList<>());
		this.productDeliverySevice.getInventoryByStore(PRODUCT,QUANTIDADE);
		verify(repository, times(1)).findByProduct(PRODUCT);

	}

	
	
}
