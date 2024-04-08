package org.example.demospring.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.example.demospring.common.Log;
import org.example.demospring.domain.Message;
import org.example.demospring.domain.repository.MessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageResource {
    private final MessageRepository repository;

    @Inject
    public MessageResource(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Message> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Message insert(@Valid Message message) {
        return repository.save(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Log.info("Delete message with ID %d", id);
        repository.deleteById(id);
        return ResponseEntity.ok("Message deleted");
    }
}
