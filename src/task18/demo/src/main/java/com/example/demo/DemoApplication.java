package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Переписать код предыдущего задания с использованием сервисов и
//отделения логики контроллера от логики сервиса и репозитория. В программе
//всё взаимодействие с базой данных должно быть реализовано через
//репозитории Spring Data Jpa
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
