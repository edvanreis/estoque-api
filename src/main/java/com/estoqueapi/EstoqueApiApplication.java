package com.estoqueapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Slf4j
@SpringBootApplication
@EntityScan(basePackages = {"com.estoqueapi.model"})
@EnableJpaRepositories(basePackages = " com.estoqueapi.repository")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class EstoqueApiApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(EstoqueApiApplication.class, args);
		var name = app.getEnvironment().getProperty("spring.application.name");
		var version = app.getEnvironment().getProperty("server.version");


		log.info("\n----------------------------------------------------------\n" +
						"Application '{}' is running!\n\t" +
						"Version: \t{}\n\t"+
						"----------------------------------------------------------",
				name, version);
	}
}
