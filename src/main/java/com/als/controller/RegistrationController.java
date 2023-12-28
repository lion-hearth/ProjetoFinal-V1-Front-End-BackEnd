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
        return "register/registration"; // Atualizado para o novo nome do arquivo HTML
    }




    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        // Adicione lógica de validação e salvamento de usuário conforme necessário
        // Certifique-se de ajustar isso de acordo com suas necessidades

        // Define o usuário como administrador se a opção estiver marcada
        if (user.isAdmin()) {
            user.setAdmin(true);
        }

        userService.saveUser(user);
        return "redirect:/login"; // Redireciona para a página de login após o cadastro
    }
}
