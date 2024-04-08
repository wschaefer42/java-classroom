package org.example.jakartatryout.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@Getter @Setter
public class Todo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(unique = true)
    private String name;
    @NotBlank @Column(length = 100)
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();

    public static Todo of(String name, String description) {
        Todo todo = new Todo();
        todo.name = name;
        todo.description = description;
        return todo;
    }
}
