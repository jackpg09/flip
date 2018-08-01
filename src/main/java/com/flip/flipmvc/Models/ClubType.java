package com.flip.flipmvc.Models;


public enum ClubType {

    DRIVER ("Driver"),
    FAIRWAY_DRIVER ("Fairway Driver"),
    MID_RANGE ("Mid-Range"),
    PUTTER ("Putter");

    private final String name;

    ClubType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
