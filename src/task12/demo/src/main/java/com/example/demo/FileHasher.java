package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//@Service используется для пометки класса,
// который предоставляет бизнес-логику приложения сервисом.
@Service
public class FileHasher {
    @Value("#{springApplicationArguments.sourceArgs[0]}")
    private String inputPath;

    @Value("#{springApplicationArguments.sourceArgs[1]}")
    private String outputPath;

    private File inputFile, outputFile;

    public FileHasher(){
        System.out.println("It's started...");
    }

    @PostConstruct
    private void init() {
        System.out.println("Preparing files...");
        inputFile = new File(inputPath);
        outputFile = new File(outputPath);
        System.out.println("Files have prepared! Continue...");
    }

    public void hash(){
        System.out.println("Started hashing data from file...");
        //проверяем файл по условию задачи
        if (inputFile.exists()) {
            try {
                //буферы для лучшего использования памяти
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                //считываем байты по пути инпута
                String data = new String(Files.readAllBytes(Paths.get(inputPath)));
                //DigestUtils – это утильный класс позволяющий зашифровать данные в MD5 и другие типы шифрования
                //Return a hexadecimal string representation of the MD5 digest of the given bytes.
                writer.write(DigestUtils.md5DigestAsHex(data.getBytes()));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                writer.write("null");
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Done!");
    }

    //главная часть: инициализация и запуск хеширования
    public void start(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        init();
        hash();
    }

    @PreDestroy
    // The purpose of this method should be to release resources or perform
    // any other cleanup tasks before the bean gets destroyed,
    // for example closing a database connection.
    private void finish(){
        System.out.println("Deleting input file...");
        inputFile.delete();
        System.out.println("Done!");
    }

}
