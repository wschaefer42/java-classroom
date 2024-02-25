package org.example.demojakarta.greeting;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.demojakarta.hello.Fillings;
import java.time.LocalDateTime;

@Entity
@Table(name = "hellos", schema = "demo")
@Getter @Setter
public class HelloEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private Fillings fillings;
    private LocalDateTime createdAt;

    public static @NotNull HelloEntity of(String name, Fillings fillings) {
        var hello = new HelloEntity();
        hello.name = name;
        hello.fillings = fillings;
        hello.createdAt = LocalDateTime.now();
        return hello;
    }
}
