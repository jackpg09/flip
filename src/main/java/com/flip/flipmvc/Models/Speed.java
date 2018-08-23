package com.flip.flipmvc.Models;

public enum Speed {

    ONE ("1"), TWO ("2"), THREE ("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
    EIGHT("8"), NINE("9"), TEN("10"), ELEVEN("11"), TWELVE("12"), THIRTEEN("13"), FOURTEEN("14");

    private final String value;


    Speed (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
