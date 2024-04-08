package org.example.hellospring.config;

import lombok.extern.java.Log;
import org.example.hellospring.domain.Town;
import org.example.hellospring.repository.TownRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Log
@Configuration
public class TownLoader {
    @Bean
    public ApplicationRunner loadTowns(TownRepository townRepository) {
        return args -> {
            townRepository.saveAll(List.of(
                    new Town("Berlin", "DEU"),
                    new Town("Zürich", "CHE")
            ));
            log.info(String.format("Loaded %d towns", townRepository.count()));
        };
    }
}
