package com.syntaxgenie.enums;

public enum CourseMode {

    LIVE_CLASS("LIVE_CLASS"), ON_DEMAND("ON_DEMAND");

    private final String value;

    CourseMode(String locator) {
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
