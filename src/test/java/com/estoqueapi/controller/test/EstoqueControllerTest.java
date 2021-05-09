package com.estoqueapi.controller.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.estoqueapi.controller.EstoqueController;
import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.dto.LojaDTO;
import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.service.ProductDeliverySevice;

@DisplayName("Tests for the EstoqueServiceTest ")
@ExtendWith(SpringExtension.class)
public class EstoqueControllerTest {

	@InjectMocks
	private EstoqueController estoqueController;
	
	@Mock
	private EstoqueService estoqueService;
	
	@Mock
	private ProductDeliverySevice productDeliverySevice;  
	
	@Mock
	private MessageSource messageSource;
	
	@Test
	void testInventoryByStore() {
		try {
			this.estoqueController.getInventoryByStore(Mockito.anyString(), Mockito.anyInt());
		} catch (EstoqueApiException e) {  
			Assertions.assertNotNull(e);
		}
	}
	
	@Test
	void testSave() {
		try {
			
			EstoqueDTO dto = EstoqueDTO.builder()
									   .product("LONE")
									   .quantity(47l)
									   .price("$5.83")
									   .type("2XL")
									   .industry("Oil & Gas Production")
									   .origin("CA")
									   .build();
			Assertions.assertEquals("Dados salvos com sucesso!",this.estoqueController.save(dto).getBody().getValue()); 
		} catch (EstoqueApiException e) {
			Assertions.assertNotNull(e);
		}
	}
	
	
}
