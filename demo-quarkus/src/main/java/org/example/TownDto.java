package org.example;

public record TownDto(String name, String countryCode) {
    TownDto(Town town) {
        this(town.name, town.countryCode);
    }
}
