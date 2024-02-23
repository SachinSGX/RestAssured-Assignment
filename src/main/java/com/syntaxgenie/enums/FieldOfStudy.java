package com.syntaxgenie.enums;

public enum FieldOfStudy {

    INTERNET_OF_THINGS("INTERNET_OF_THINGS"), COMPUTER_ARCHITECTURE("COMPUTER_ARCHITECTURE"), CYBERSECURITY("CYBERSECURITY");

    private final String value;

    FieldOfStudy(String locator) {
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
