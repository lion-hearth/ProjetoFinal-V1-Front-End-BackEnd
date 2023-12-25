package com.als.service;

import com.als.entity.Suggestion;
import java.util.List;

public interface SuggestionService {
    List<Suggestion> getAllSuggestions();
    void approveSuggestion(Long suggestionId);
    void rejectSuggestion(Long suggestionId);
    void processSuggestion(String suggestionText);
}
