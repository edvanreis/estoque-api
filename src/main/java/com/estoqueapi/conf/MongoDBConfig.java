package com.estoqueapi.conf;

import com.estoqueapi.repository.EstoqueRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = EstoqueRepository.class)
@Configuration
public class MongoDBConfig {
}
