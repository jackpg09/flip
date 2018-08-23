package com.flip.flipmvc.Models;

public enum Fade {

    ZERO ("0"), ONE ("1"), TWO ("2"), THREE ("3"), FOUR("4"), FIVE("5"), SIX("6");

    private final String value;


    Fade (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
