package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorizationController {
    private final UserAppService userAppService;

    @Autowired
    public AuthorizationController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login.html";
    }

    @GetMapping("/web-home")
    public String getIndexPage() {
        return "home.html";
    }

    /**
     * @ModelAttribute — аннотация, которая связывает параметр метода или
     * возвращаемое значение метода с именованным атрибутом модели, а затем предоставляет его веб-представлению.
     * */

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") User user) {
        return "registration.html";
    }

    @PostMapping("/registration")
    public String signUpUser(@ModelAttribute("user") User user) {
        return userAppService.singUp(user);
    }
}
