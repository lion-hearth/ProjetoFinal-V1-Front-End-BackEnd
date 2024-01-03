package com.als.controller;

import com.als.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    @PostMapping("/api/suggestions")
    @ResponseBody
    public ResponseEntity<String> submitSuggestion(@RequestBody String suggestionText) {
        // Validar o comprimento da sugestão
        int maxCharacters = 1000;
        if (suggestionText.length() > maxCharacters) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A sugestão excede o limite de caracteres permitido (máximo " + maxCharacters + " caracteres).");
        }

        suggestionService.processSuggestion(suggestionText);
        return ResponseEntity.ok("Sugestão recebida com sucesso!");
    }
}

