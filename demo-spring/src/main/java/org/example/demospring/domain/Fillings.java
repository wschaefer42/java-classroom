package org.example.demospring.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum Fillings {
    SAD ("sad"),
    OKAY ("okay"),
    GREAT ("great"),
    UNKNOWN ("unknown");

    private final String value;

    Fillings(String value) {
        this.value = value;
    }

    public static List<String> getValues() {
        return Arrays.stream(Fillings.values()).map(f -> f.value).toList();
    }
}
