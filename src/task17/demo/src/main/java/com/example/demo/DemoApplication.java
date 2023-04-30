package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Добавить возможность фильтрации по всем полям всех классов с
//использованием Criteria API в Hibernate для программы из предыдущего
//задания. Добавить эндпоинты для каждой фильтрации.

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
