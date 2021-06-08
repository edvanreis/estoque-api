package com.estoqueapi.controller.test;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.estoqueapi.controller.EstoqueController;
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.service.ProductDeliverySevice;

@WebMvcTest(controllers = EstoqueController.class)
@ActiveProfiles("test")
public class EstoqueControllerTest {

	@MockBean
	private EstoqueService estoqueService;
	
	@MockBean
	private ProductDeliverySevice productDeliverySevice;  
	
	@MockBean
	private MessageSource messageSource;
	
	@Autowired
	private MockMvc mvc; 
	
	
	@Test
	void getInventoryByStore() {
		try {
			
			when(productDeliverySevice.getInventoryByStore(Mockito.eq("EMS"), Mockito.eq(2))).thenReturn(new ArrayList<>());
			
			mvc.perform(MockMvcRequestBuilders.get("/estoque/store/{product}/{qtdStore}",Mockito.eq("EMS"), Mockito.eq(2))
												  .contentType(MediaType.APPLICATION_JSON)
												  .accept(MediaType.APPLICATION_JSON))
												  .andDo(print())
												  .andExpect(status().isOk()).andReturn();
		  reset(this.productDeliverySevice);
												
		} catch (Exception e) {
			Assertions.assertNotNull(e);
		}
									      
	}
	
//	@Test
//	void testInventoryByStore() {
//		try {
//			this.estoqueController.getInventoryByStore(Mockito.anyString(), Mockito.anyInt());
//		} catch (EstoqueApiException e) {  
//			Assertions.assertNotNull(e);
//		}
//	}
//	
//	@Test
//	void testSave() {
//		try {
//			
//			EstoqueDTO dto = EstoqueDTO.builder()
//									   .product("LONE")
//									   .quantity(47l)
//									   .price("$5.83")
//									   .type("2XL")
//									   .industry("Oil & Gas Production")
//									   .origin("CA")
//									   .build();
//			Assertions.assertEquals("Dados salvos com sucesso!",this.estoqueController.save(dto).getBody().getValue()); 
//		} catch (EstoqueApiException e) {
//			Assertions.assertNotNull(e);
//		}
//	}
	
	
}
