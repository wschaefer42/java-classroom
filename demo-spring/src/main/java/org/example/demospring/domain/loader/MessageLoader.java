package org.example.demospring.domain.loader;

import lombok.extern.java.Log;
import org.example.demospring.domain.Fillings;
import org.example.demospring.domain.Message;
import org.example.demospring.domain.repository.MessageRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.util.List;

@Log
@Configuration
@Profile("testdata")
public class MessageLoader {
    @Bean
    public ApplicationRunner initMessageDB(MessageRepository repository) {
        return args -> {
            repository.truncateTable();
            repository.saveAll(List.of(
                    Message.of("Werner", Fillings.SAD),
                    Message.of("Manuela", Fillings.GREAT),
                    Message.of("Peter", Fillings.OKAY)
            ));
            long count = repository.count();
            log.info(String.format("Loaded %d message records", count));
        };
    }
}
