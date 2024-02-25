package org.example.demojakarta.hello;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;

import java.time.LocalDateTime;

@Startup
@Singleton
@Log
public class HelloLoader {
    @Inject
    private HelloData helloData;

    @Transactional
    @PostConstruct
    void loadData() {
        helloData.getHistory().add(new HelloData.Hello("Rumpelstiltskin", Fillings.OKAY, LocalDateTime.now()));
    }
}
