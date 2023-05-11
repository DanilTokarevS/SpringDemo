package com.example.lab5_spring.controllers;


import com.example.lab5_spring.Entity.flight;
import com.example.lab5_spring.Entity.passengers;
import com.example.lab5_spring.repositories.flightRepositories;
import com.example.lab5_spring.repositories.passengersRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private flightRepositories flightRepositories;

    private passengersRepositories passengersRepositories;

    public UsersController(flightRepositories flightRepositories, passengersRepositories passengersRepositories) {
        this.flightRepositories=flightRepositories;
        this.passengersRepositories = passengersRepositories;
    }

    @GetMapping("/admin")
    public String showDepartment(Model model) {
        List<String> list = passengersRepositories.findAll()
                .stream()
                .map(passengers::toString)
                .toList();

        model.addAttribute("list", list);
        model.addAttribute("userRole", "Admin");
        return "adminTable";
    }



    @GetMapping("/user")
    public String showEmployees(Model model) {
        List<String> list = flightRepositories.findAll()
                .stream()
                .map(flight::toString)
                .toList();

        model.addAttribute("list", list);
        model.addAttribute("userRole", "User");
        return "userTable";
    }


}
