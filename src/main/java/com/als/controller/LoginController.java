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
        return "login_page/login_page";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam(name = "admin", defaultValue = "false") boolean isAdmin,
                        Model model) {

        if (userService.authenticate(username, password)) {
            if (isAdmin) {
                return "redirect:/admin/admin_page?email=Email Padrão&nome=Nome Padrão&sugestao=Sugestão Padrão";
            } else {
                return "redirect:/user_register";
            }
        } else {
            model.addAttribute("error", "Credenciais inválidas. Tente novamente.");
            return "login_page/login_page";
        }
    }

    @GetMapping("/user_register")
    public String showUserRegisterPage() {
        return "user_register"; // Corrija o nome do template se necessário
    }

    @PostMapping("/user_register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String nome,
                               @RequestParam String email,
                               @RequestParam String password,
                               Model model) {
        // Lógica para salvar o usuário
        User user = new User();
        user.setUsername(username);
        user.setNome(nome);
        user.setEmail(email);
        user.setPassword(password);

        userService.saveUser(user);

        return "redirect:/login?success=true";
    }
}
