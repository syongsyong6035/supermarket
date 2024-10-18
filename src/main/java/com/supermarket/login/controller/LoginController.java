package com.supermarket.login.controller;

import com.supermarket.login.dto.UserDTO;
import com.supermarket.login.service.loginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final loginService loginservice;

    public LoginController(loginService loginservice) {
        this.loginservice = loginservice;
    }

    @GetMapping("/register")
    public String regist() {
        return "mypage/register";
    }
    @PostMapping("/register")
    public String saveregister(@ModelAttribute UserDTO userdto) {
        loginservice.registersave(userdto);
        return "mypage/login";
    }

    @GetMapping("/login")
    public String login() {
        return "mypage/login";
    }
}

