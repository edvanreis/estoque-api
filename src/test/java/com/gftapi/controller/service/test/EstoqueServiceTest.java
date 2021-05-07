package com.gftapi.controller.service.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gftapi.exception.GftApiException;
import com.gftapi.service.EstoqueService;
import com.gftapi.service.ProductDeliverySevice;

@DisplayName("Tests for the EstoqueServiceTest ")
@ExtendWith(SpringExtension.class)
public class EstoqueServiceTest {

	@InjectMocks
	private ProductDeliverySevice productDeliverySevice;
	
	@Mock
	private EstoqueService estoqueService;
	
	@Test
	void calcularLojas() {
		try {
			Mockito.when(this.estoqueService.findByProduct(Mockito.anyString())).thenReturn(new ArrayList<>());
			this.productDeliverySevice.getInventoryByStore(Mockito.anyString(), 2);
		} catch (GftApiException e) {
			Assertions.assertNotNull(e);
		}
		
	}
	
	
}
