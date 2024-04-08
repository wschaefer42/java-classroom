package org.example.demospring.service;

import jakarta.inject.Inject;
import org.example.demospring.domain.Fillings;
import org.example.demospring.domain.Message;
import org.example.demospring.domain.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepository repository;

    @Inject
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    private Message createOrUpdate(String name, Fillings fillings) {
        Message message = repository.findByName(name);
        if (message == null) {
            return repository.save(Message.of(name, fillings));
        } else {
            repository.updateFillingsById(message.getId(), fillings);
            return repository.findById(message.getId()).orElseThrow();
        }
    }
}
