package org.example.jakartahello.domain;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;

import java.util.List;

@Startup
@Singleton
@Log
public class MessageLoader {
    @Inject
    private MessageRepository repository;

    @Transactional
    @PostConstruct
    void loadData() {
        repository.truncate();
        List.of(
                Message.of("Werner", Fillings.SAD),
                Message.of("Manuela", Fillings.GREAT),
                Message.of("Peter", Fillings.OKAY)
        ).forEach(message -> repository.save(message));
        long count = repository.count();
        log.info(String.format("Loaded %d hello records", count));
    }
}
