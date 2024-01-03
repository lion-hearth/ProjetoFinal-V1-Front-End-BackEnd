package com.als.controller;

import com.als.entity.User;
import com.als.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registerUser")
    public String showUserRegistrationPage() {
        return "user_register";
    }

    @PostMapping("/registerUser")
    public String registerRegularUser(User user, Model model) {

        userService.saveUser(user);
        return "redirect:/suggestions";
    }
}

