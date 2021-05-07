package com.estoqueapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.estoqueapi.service.EstoqueService;

@SpringBootTest
class GftapiApplicationTests {

	@Autowired
	EstoqueService service;
	
	@Test
	public void contextLoads() {
		//this.service.getInventoryByStore("EMMS", 2);
	}

}
