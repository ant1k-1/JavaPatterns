package com.example.demo.configuration;

import com.example.demo.components.Junior;
import com.example.demo.components.Middle;
import com.example.demo.components.Senior;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Данная аннотация говорит о том, что этот класс является источником
//определения бинов
@Configuration
public class ProgrammerConfig {
    @Bean("Junior")
    public Junior junior(){
        return new Junior();
    }
    @Bean("Middle")
    public Middle middle(){
        return new Middle();
    }
    @Bean("Senior")
    public Senior senior(){
        return new Senior();
    }
}
