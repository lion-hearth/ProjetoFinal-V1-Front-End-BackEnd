package com.als.controller;

import com.als.entity.Suggestion;
import com.als.entity.User;
import com.als.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.als.service.SuggestionService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SuggestionService suggestionService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/suggestions")
    public ModelAndView showSuggestions(Model model) {
        List<Suggestion> suggestions = suggestionService.getAllSuggestions();
        model.addAttribute("suggestions", suggestions);
        return new ModelAndView("admin/admin_page"); // Corrigindo o nome da página
    }

    @GetMapping("/admin_page")  // Caminho da página admin_page
    public ModelAndView showAdminPage(Model model,
                                      @RequestParam(name = "email", required = false, defaultValue = "Email Padrão") String email,
                                      @RequestParam(name = "nome", required = false, defaultValue = "Nome Padrão") String nome,
                                      @RequestParam(name = "sugestao", required = false, defaultValue = "Sugestão Padrão") String sugestao) {
        List<Suggestion> suggestions = suggestionService.getAllSuggestions();
        List<User> listUsername = userRepository.findAll();
        model.addAttribute("username", listUsername);
        model.addAttribute("suggestions", suggestions);
        model.addAttribute("nome", nome);
        model.addAttribute("sugestao", sugestao);

        // Agora você pode usar os dados como necessário
        // Certifique-se de validar e processar esses dados adequadamente

        return new ModelAndView("admin/admin_page");
    }

    @PostMapping("/suggestions/approve")
    @ResponseBody
    public ResponseEntity<String> approveSuggestion(@RequestParam Long suggestionId) {
        suggestionService.approveSuggestion(suggestionId);
        return ResponseEntity.ok("Sugestão aprovada com sucesso!");
    }

    @PostMapping("/suggestions/reject")
    @ResponseBody
    public ResponseEntity<String> rejectSuggestion(@RequestParam Long suggestionId) {
        suggestionService.rejectSuggestion(suggestionId);
        return ResponseEntity.ok("Sugestão rejeitada com sucesso!");
    }

    @GetMapping("/user_register")
    public String showUserRegisterPage(Model model) {
        model.addAttribute("success", true); // Adiciona o atributo de sucesso ao modelo
        return "admin/user_register"; // Nome da página de cadastro de usuários
    }
}
