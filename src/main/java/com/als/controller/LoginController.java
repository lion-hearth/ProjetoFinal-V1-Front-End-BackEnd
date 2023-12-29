package com.als.controller;

import com.als.entity.User;
import com.als.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "front/login_page";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam(name = "admin", defaultValue = "false") boolean isAdmin,
                        Model model) {

        if (userService.authenticate(username, password)) {
            if (isAdmin) {
                return "redirect:/admin/admin_page"; // Redireciona para a página admin_page se for administrador
            } else {
                return "redirect:/user_page"; // Redireciona para a página user_page se não for administrador
            }
        } else {
            model.addAttribute("error", "Credenciais inválidas. Tente novamente.");
            return "front/login_page";
        }
    }
}