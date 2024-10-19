package com.template.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
// @EnableMongoRepositories(basePackages =
// "com.template.demo.repository.MongoRepository")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
