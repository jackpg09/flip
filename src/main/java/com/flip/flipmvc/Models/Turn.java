package com.flip.flipmvc.Models;

public enum Turn {
    NEG5 ("-5"), NEG4 ("-4"), NEG3 ("-3"), NEG2 ("-2"), NEG1 ("-1"), ZERO ("0"), ONE ("1");

    private final String value;


    Turn (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
