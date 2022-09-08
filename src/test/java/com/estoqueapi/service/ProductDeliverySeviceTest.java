package com.estoqueapi.service;

import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.mock.Mocks;
import com.estoqueapi.service.impl.ProductDeliverySeviceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;

@DisplayName("Tests for the ProductDeliverySeviceTest ")
@RunWith(SpringRunner.class)
public class ProductDeliverySeviceTest {

	@InjectMocks
	private ProductDeliverySeviceImpl productDeliverySevice;
	
	@Mock
	private EstoqueService repository;
	
	@Mock
	private  MessageSource messageSource;
	
	
	@Test
	public void when_getInventoryByStoreSizeTwoReturnOK() {
		when(this.repository.findByProduct("LONE")).thenReturn(Arrays.asList(Mocks.createEstoque()));
		this.productDeliverySevice.getInventoryByStore("LONE",2);
	}

	@Test
	public void when_getInventoryByStoreOneReturnOK() {
		when(this.repository.findByProduct("LONE")).thenReturn(Arrays.asList(Mocks.createEstoque()));
		this.productDeliverySevice.getInventoryByStore("LONE",1);
	}

	@Test(expected = EstoqueApiException.class)
	public void when_getInventoryByStoreDoNotReturnOK() {
		when(this.repository.findByProduct("LONE")).thenReturn(new ArrayList<>());
		this.productDeliverySevice.getInventoryByStore("LONE",2);

	}

	
	
}
