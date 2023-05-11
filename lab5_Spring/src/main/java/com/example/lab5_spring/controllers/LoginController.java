package com.example.lab5_spring.controllers;


import com.example.lab5_spring.Entity.Users;
import com.example.lab5_spring.dao.LoginForm;
import com.example.lab5_spring.repositories.userRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

private userRepositories userRepositories;


public LoginController(userRepositories userRepositoriesS){
this.userRepositories = userRepositoriesS;

}


    @GetMapping
    public String getLogin() {
        log.info("login");
        return "login";
    }

    @PostMapping
    public String redirect(@ModelAttribute("loginForm") LoginForm loginForm) {
        try {
            Users user = userRepositories.findByUsername(loginForm.getUsername())
                    .orElseThrow(() -> new UserPrincipalNotFoundException(
                            "User with username " +
                                    loginForm.getUsername() +
                                    "is not found")
                    );
            if (user.getPassword().equals(loginForm.getPassword())) {
                if (user.getIdRole() == 1)
                    return "redirect:/users/admin";
                else
                    return "redirect:/users/user";

            }

            throw new UserPrincipalNotFoundException("Invalid password for user " + loginForm.getUsername());
        } catch (UserPrincipalNotFoundException e) {
            log.warn(e.getMessage());
        }

        return null;
    }


}
