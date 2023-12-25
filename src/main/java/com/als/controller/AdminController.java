package com.als.controller;

import com.als.entity.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.als.service.SuggestionService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private SuggestionService suggestionService;

    @GetMapping("/admin/suggestions")
    public ModelAndView showSuggestions(Model model) {
        List<Suggestion> suggestions = suggestionService.getAllSuggestions();
        model.addAttribute("suggestions", suggestions);
        return new ModelAndView("admin_suggestions");
    }

    @GetMapping("/admininstrador/admin_page")
    public ModelAndView showAdminPage(Model model) {
        List<Suggestion> suggestions = suggestionService.getAllSuggestions();
        model.addAttribute("suggestions", suggestions);
        return new ModelAndView("admin/admin_page"); // Corrigindo o nome da página
    }

    @PostMapping("/admin/suggestions/approve")
    @ResponseBody
    public ResponseEntity<String> approveSuggestion(@RequestParam Long suggestionId) {
        suggestionService.approveSuggestion(suggestionId);
        return ResponseEntity.ok("Sugestão aprovada com sucesso!");
    }

    @PostMapping("/admin/suggestions/reject")
    @ResponseBody
    public ResponseEntity<String> rejectSuggestion(@RequestParam Long suggestionId) {
        suggestionService.rejectSuggestion(suggestionId);
        return ResponseEntity.ok("Sugestão rejeitada com sucesso!");
    }
}
