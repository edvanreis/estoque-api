package com.estoqueapi.controller.test;

import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.estoqueapi.controller.EstoqueController;
import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.service.ProductDeliverySevice;
import com.google.gson.Gson;

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
	void when_inventoryByStore() {
		try {
			
		
			mvc.perform(MockMvcRequestBuilders.get("/estoque/{product}/{qtdStore}/store","EMS",2)
												  .contentType(MediaType.APPLICATION_JSON)
												  .accept(MediaType.APPLICATION_JSON))
												  .andDo(print())
												  .andExpect(status().isOk());
												
		} catch (Exception e) {
			Assertions.assertNotNull(e);
		}
									      
	}
	
	@Test
	void when_save() {
		try {
			
			EstoqueDTO dto = EstoqueDTO.builder()
						   .product("LONE")
						   .quantity(47l)
						   .price("$5.83")
						   .type("2XL")
						   .industry("Oil & Gas Production")
						   .origin("CA")
						   .build();
			
			 Gson gson = new Gson();
			 String json = gson.toJson(dto);	
			 
			 System.out.println(json); 
				mvc.perform(MockMvcRequestBuilders.post("/estoque")
										  .content(json.toString())
										  .contentType(MediaType.APPLICATION_JSON)
										  .accept(MediaType.APPLICATION_JSON))
										  .andDo(print())
										  .andExpect(status().isOk());
				
												
		} catch (Exception e) {
			Assertions.assertNotNull(e);
		}
									      
	}
	
	
	@Test
	void when_findAll() {
		try {
				mvc.perform(MockMvcRequestBuilders.get("/estoque")
										  .contentType(MediaType.APPLICATION_JSON)
										  .accept(MediaType.APPLICATION_JSON))
										  .andDo(print())
										  .andExpect(status().isOk());
				
		} catch (Exception e) {
			Assertions.assertNotNull(e);
		}
									      
	}

	
	
}
