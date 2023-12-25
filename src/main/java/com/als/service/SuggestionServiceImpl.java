package com.als.service;

import com.als.entity.Suggestion;
import com.als.repository.SuggestionRepository; // Importe a interface do repositório
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;

    @Autowired
    public SuggestionServiceImpl(SuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }

    @Override
    public List<Suggestion> getAllSuggestions() {
        return suggestionRepository.findAll();
    }

    @Override
    public void approveSuggestion(Long suggestionId) {
        Optional<Suggestion> optionalSuggestion = suggestionRepository.findById(suggestionId);
        optionalSuggestion.ifPresent(suggestion -> {
            suggestion.setApproved(true);
            suggestionRepository.save(suggestion);
        });
    }

    @Override
    public void rejectSuggestion(Long suggestionId) {
        suggestionRepository.deleteById(suggestionId);
    }

    @Override
    public void processSuggestion(String suggestionText) {
        Suggestion suggestion = new Suggestion();
        suggestion.setText(suggestionText);
        suggestionRepository.save(suggestion);
    }
}
