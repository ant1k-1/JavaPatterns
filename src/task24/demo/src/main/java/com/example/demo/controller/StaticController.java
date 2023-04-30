package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {
    @GetMapping(value = "/home")
    public String getHomePage(){
        return "index.html";
    }
}
