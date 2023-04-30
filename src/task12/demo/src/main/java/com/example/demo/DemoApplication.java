package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Создать приложение, которое при запуске берет данные из одного
// файла, хеширует, а при остановке приложения удаляет исходный файл,
// оставляя только файл с захешированными данными. Названия первого и
// второго файла передаются в качестве аргументов при запуске. При отсутствии
// первого файла создает второй файл и записывает в него строку null.
// Реализовать с использованием аннотаций PostConstruct, PreDestroy.
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	//Аннотация Autowired попросила Spring в поле, которое она аннотирует, подставить значение.
	//Эта операция называется «инжектнуть» (inject)
	@Autowired
	private FileHasher fileHasher;
	public static void main(String[] args) {
		// terminal run command below
		// java -jar ./build/libs/demo-0.0.1-SNAPSHOT.jar D:\me\University\JavaPatterns\src\task12\demo\src\main\java\com\example\demo\input.txt D:\me\University\JavaPatterns\src\task12\demo\src\main\java\com\example\demo\output.txt
		// java -jar ./build/libs/demo-0.0.1-SNAPSHOT.jar C:\Users\Anton\Desktop\University\JavaPatterns\src\task12\demo\src\main\java\com\example\demo\input.txt C:\Users\Anton\Desktop\University\JavaPatterns\src\task12\demo\src\main\java\com\example\demo\output.txt
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 2) fileHasher.start(args[0], args[1]);
		else fileHasher.hash();
		// else standard input.txt-output.txt we will see
	}
}
