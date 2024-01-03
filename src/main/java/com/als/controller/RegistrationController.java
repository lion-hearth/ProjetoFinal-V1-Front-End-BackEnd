package com.als.controller;

import com.als.entity.User;
import com.als.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register/registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {


        // Define o usuário como administrador se a opção estiver marcada
        if (user.isAdmin()) {
            user.setAdmin(true);
        }

        // Verifica se o e-mail não é nulo ou vazio antes de definir o username
        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
            user.setUsername(user.getEmail());
        }

        userService.saveUser(user);

        //  model para ser exibida na página
        model.addAttribute("successMessage", "Cadastro realizado com sucesso!");

        // Redireciona para a página de login
        return "redirect:/login";
    }
}
