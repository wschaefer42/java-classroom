package org.example.demospring.resource;

import jakarta.inject.Inject;
import org.example.demospring.domain.Greeting;
import org.example.demospring.domain.Greeting.Formality;
import org.example.demospring.domain.repository.GreetingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/greetings")
public class GreetingResource {
    private final GreetingRepository repository;

    @Inject
    public GreetingResource(GreetingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Greeting> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Greeting getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @GetMapping("/hello/{lang}")
    public ResponseEntity<String> sayHello(@PathVariable String lang, @RequestParam(defaultValue = "Nobody") String name) {
        var greeting = repository.findByLangAndFormality(lang, Formality.INFORMAL);
        return greeting
                .map(value -> ResponseEntity.ok(String.format("%s %s", value.getText(), name)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
