package org.example.demojakarta.hello;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class HelloRepository {
    @Inject
    private HelloData helloData;

    public List<String> findAll() {
        return helloData.getHistory().stream().map(HelloData.Hello::name).toList();
    }

    public List<HelloData.Hello> getAll() {
        return helloData.getHistory();
    }

    public void add(String user, Fillings filling) {
        helloData.getHistory().add(new HelloData.Hello(user, filling, LocalDateTime.now()));
    }
}
