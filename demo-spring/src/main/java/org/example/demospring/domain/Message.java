package org.example.demospring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages", schema = "demo")
@Getter @Setter
public class Message {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private Fillings fillings;
    private LocalDateTime createdAt;

    public static @NotNull Message of(String name, Fillings fillings) {
        var hello = new Message();
        hello.name = name;
        hello.fillings = fillings;
        hello.createdAt = LocalDateTime.now();
        return hello;
    }
}
