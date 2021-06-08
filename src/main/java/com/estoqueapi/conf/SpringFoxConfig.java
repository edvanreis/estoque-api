package com.estoqueapi.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
			   .select()
			   .apis(RequestHandlerSelectors.any())
			   .paths(PathSelectors.any())
			   .build()
			   .apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
          "Produtos API REST",
          "API REST de cadastro de produtos", 
          "1.0", 
          "Terms of Service", 
          new Contact("Edvan Reis","https://github.com/edvanreis/estoque-api", "edvan.reis.moura@gmail.com"), 
          null, null, null);
		
		return apiInfo;
	}

}
