package com.syntaxgenie.enums;

public enum CourseType {

    SHORT_COURSE("SHORT_COURSE"), WORKSHOP("WORKSHOP"), COURSE("COURSE");

    private final String value;

    CourseType(String locator) {
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
