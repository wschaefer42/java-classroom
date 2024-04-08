package org.example.demospring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Entity
@Table(
        name = "greetings",
        schema = "demo",
        indexes = @Index(columnList = "lang"),
        uniqueConstraints = @UniqueConstraint(columnNames = { "formality", "lang" })
)
@Getter @Setter
public class Greeting {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String text;
    @NotBlank @Column(length = 2)
    private String lang;
    private Formality formality;
    @Transient
    public boolean isFormal() {
        return formality == Formality.FORMAL;
    }
    @Getter
    public enum Formality {
        FORMAL(1),
        INFORMAL(2),
        SLANG(3);
        private final int value;
        Formality(int value) {
            this.value = value;
        }
        public static Formality valueOf(int value) {
            return Arrays.stream(values()).filter(v -> v.value == value).findFirst().orElseThrow();
        }
    }
    public static Greeting of(String text, String lang, Formality formality) {
        Greeting greeting = new Greeting();
        greeting.text = text;
        greeting.lang = lang;
        greeting.formality = formality;
        return greeting;
    }
}
