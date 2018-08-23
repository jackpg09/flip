package com.flip.flipmvc.Models;

public enum Glide {
    ONE ("1"), TWO ("2"), THREE ("3"), FOUR("4"), FIVE("5"),SIX ("6"), SEVEN("7");

    private final String value;


    Glide (String value) {
        this.value = value;
    }

    public String getValue() {

        return value;
    }
}
