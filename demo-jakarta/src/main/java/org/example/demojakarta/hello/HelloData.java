package org.example.demojakarta.hello;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@ApplicationScoped
public class HelloData {
    public record Hello (
            String name,
            Fillings filling,
            LocalDateTime createdAt) {}
    private final List<Hello> history = new ArrayList<>();
    HelloData() {
    }


}
