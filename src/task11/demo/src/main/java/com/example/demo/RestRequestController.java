package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestRequestController {
    @GetMapping("/get_status")
    public String test_rest(){
        return "Проверка REST-запроса";
    }
}
