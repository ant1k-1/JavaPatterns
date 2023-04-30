package com.example.demo;

import com.example.demo.configuration.ProgrammerConfig;
import com.example.demo.interfaces.Programmer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		ApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ProgrammerConfig.class);
		Programmer junior = (Programmer) applicationContext.getBean("Junior");
		Programmer middle = (Programmer) applicationContext.getBean("Middle");
		Programmer senior = (Programmer) applicationContext.getBean("Senior");
		junior.doCoding();
		middle.doCoding();
		senior.doCoding();
	}
}
