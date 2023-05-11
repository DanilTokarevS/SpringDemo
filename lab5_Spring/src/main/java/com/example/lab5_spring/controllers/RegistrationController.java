package com.example.lab5_spring.controllers;


import com.example.lab5_spring.dao.RegisterForm;
import com.example.lab5_spring.repositories.userRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private userRepositories userRepositories;

    public RegistrationController(userRepositories userRepositories){this.userRepositories= userRepositories;}


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("registerForm") RegisterForm form) {
        userRepositories.save(form.toUser());
        return "redirect:/login";
    }



}
