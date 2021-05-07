package com.estoqueapi.controller.service.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.service.ProductDeliverySevice;

@DisplayName("Tests for the EstoqueServiceTest ")
@ExtendWith(SpringExtension.class)
public class ProductDeliverySeviceTest {

	@Mock
	private ProductDeliverySevice productDeliverySevice;
	
	
	@Test
	void getInventoryByStoreTest() {
		try {
			this.productDeliverySevice.getInventoryByStore("EMMS", 2);
		} catch (EstoqueApiException e) {
			Assertions.assertNotNull(e);
		}
		
	}
	
	
}
