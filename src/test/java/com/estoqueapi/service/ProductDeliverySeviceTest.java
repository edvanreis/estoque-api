package com.estoqueapi.service;

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
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.service.impl.ProductDeliverySeviceImpl;

@DisplayName("Tests for the EstoqueServiceTest ")
@ExtendWith(SpringExtension.class)
public class ProductDeliverySeviceTest {

	@InjectMocks
	private ProductDeliverySeviceImpl productDeliverySevice;
	
	@Mock
	private EstoqueService repository;
	
	@Mock
	private  MessageSource messageSource;
	
	
	@Test
	void getInventoryByStoreTest() {
		try {
			when(this.repository.findByProduct("EMS")).thenReturn(new ArrayList<>());
			this.productDeliverySevice.getInventoryByStore("EMS",2);
		} catch (EstoqueApiException e) {
			Assertions.assertNotNull(e);
		}
		
	}
	
	
}
