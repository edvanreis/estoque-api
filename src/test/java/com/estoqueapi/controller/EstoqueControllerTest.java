package com.estoqueapi.controller;

import com.estoqueapi.mock.Mocks;
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.service.ProductDeliverySevice;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EstoqueController.class)
@RunWith(SpringRunner.class)
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
	@SneakyThrows
	public void when_inventoryByStoreReturnOK() {
		mvc.perform(MockMvcRequestBuilders.get("/estoque/{product}/{qtdStore}/store","EMS",2)
											  .contentType(MediaType.APPLICATION_JSON)
											  .accept(MediaType.APPLICATION_JSON))
											  .andDo(print())
											  .andExpect(status().isOk());

	}
	
	@Test
	@SneakyThrows
	public void when_saveReturnOK() {
		 var estoque = Mocks.createEstoqueDto();
		 var  payload = new Gson().toJson(estoque);
			mvc.perform(MockMvcRequestBuilders.post("/estoque")
									  .content(payload.toString())
									  .contentType(MediaType.APPLICATION_JSON)
									  .accept(MediaType.APPLICATION_JSON))
									  .andDo(print())
									  .andExpect(status().isCreated());

									      
	}

	@Test
	@SneakyThrows
	public void when_saveAllReturnOK() {
		var estoque = Mocks.createEstoqueDto();
		var  payload = new Gson().toJson(estoque);
		mvc.perform(MockMvcRequestBuilders.post("/estoque/saveAll")
						.content(payload.toString())
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());


	}
	
	
	@Test
	@SneakyThrows
	public void when_findAllReturnOK() {

		mvc.perform(MockMvcRequestBuilders.get("/estoque")
								  .contentType(MediaType.APPLICATION_JSON)
								  .accept(MediaType.APPLICATION_JSON))
								  .andDo(print())
								  .andExpect(status().isOk());
				

									      
	}

	
	
}
