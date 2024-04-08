package org.example.demospring.service;

import org.example.demospring.domain.Greeting;
import org.example.demospring.domain.dto.GreetingRecord;
import org.example.demospring.domain.repository.GreetingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GreetingService {
    private final GreetingRepository repository;

    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }

    public List<GreetingRecord> getAll() {
        return repository.findAllByFormality(Greeting.Formality.INFORMAL).stream()
                .map(e -> new GreetingRecord(e.getLang(), e.getText()))
                .toList();
    }

    public GreetingRecord getByLang(String lang) {
        return repository.findByLangAndFormality(lang, Greeting.Formality.INFORMAL)
                .map(GreetingService::mapping)
                .orElseThrow();
    }

    private static GreetingRecord mapping(Greeting greeting) {
        return new GreetingRecord(greeting.getLang(), greeting.getText());
    }
}
