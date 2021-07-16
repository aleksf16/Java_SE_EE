package com.example.api1;

import item.itemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import user.userRepository;


@SpringBootApplication
@ComponentScan(basePackages = {"user", " item", "cart"})
@EnableMongoRepositories(basePackages = {"user", "item", "cart"})
public class Api1Application {

	public static void main(String[] args) {
		SpringApplication.run(Api1Application.class, args);
	}

}
