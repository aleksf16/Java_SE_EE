package com.example.api1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com/example/api1/user", "com/example/api1/item", "com/example/api1/cart"})
@EnableMongoRepositories(basePackages = {"com/example/api1/user", "com/example/api1/item", "com/example/api1/cart"})
public class Api1Application {

	public static void main(String[] args) {
		SpringApplication.run(Api1Application.class, args);
	}

}
