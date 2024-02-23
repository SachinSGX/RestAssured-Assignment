package com.syntaxgenie.enums;

public enum DifficultyLevel {

    BEGINNER("BEGINNER"), INTERMEDIATE("INTERMEDIATE"), ADVANCED("ADVANCED");

    private final String value;

    DifficultyLevel(String locator) {
        this.value = locator;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
