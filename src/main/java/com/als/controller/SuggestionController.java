package com.als.controller;

import com.als.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    @PostMapping("/api/suggestions")
    @ResponseBody
    public ResponseEntity<String> submitSuggestion(@RequestBody Map<String, String> suggestion) {
        String suggestionText = suggestion.get("suggestion");
        suggestionService.processSuggestion(suggestionText);
        return ResponseEntity.ok("Sugestão recebida com sucesso!");
    }
}
