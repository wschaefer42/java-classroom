package org.example.demospring.domain.loader;

import lombok.extern.java.Log;
import org.example.demospring.domain.Greeting;
import org.example.demospring.domain.repository.GreetingRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.example.demospring.domain.Greeting.Formality;
import java.util.List;

@Log
@Configuration
@Profile("testdata")
public class GreetingLoader {
    @Bean
    public ApplicationRunner initGreetingDB(GreetingRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    Greeting.of("Hello", "en", Formality.INFORMAL),
                    Greeting.of("Good morning", "en", Formality.FORMAL),
                    Greeting.of("Hi", "en", Formality.SLANG),
                    Greeting.of("Hallo", "de", Formality.INFORMAL),
                    Greeting.of("Ciao", "ch", Formality.INFORMAL),
                    Greeting.of("Bonjour", "fr", Formality.FORMAL),
                    Greeting.of("Salut", "fr", Formality.INFORMAL),
                    Greeting.of("Halo", "es", Formality.INFORMAL)
            ));
        };
    }
}
