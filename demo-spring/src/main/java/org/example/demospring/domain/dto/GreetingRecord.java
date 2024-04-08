package org.example.demospring.domain.dto;

// Instead of a DTO
public record GreetingRecord (String lang, String text) {
    public String langText() {
        return switch (lang) {
            case "de" -> "German";
            case "en" -> "English";
            case "fr" -> "French";
            case "es" -> "Spain";
            case "ch" -> "Swiss";
            default -> "Unknown";
        };
    }
}
