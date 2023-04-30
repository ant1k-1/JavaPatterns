package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Создать отдельный репозиторий Git. Создать простой html-документ,
//который будет содержать вашу фамилию, имя, номер группы, номер варианта.
//Создать контроллер, который будет возвращать данный статический
//документ при переходе на url «/home». Выполнить задание в зависимости с
//вариантом индивидуального задания.

//14) Создать класс Patient с полями firstName, lastName. Создать класс
//Doctor с полями firstName, lastName, position. Создать классы-контроллеры
//для создания, удаления объектов и получения всех объектов каждого типа.
//Сами объекты хранить в памяти.
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
