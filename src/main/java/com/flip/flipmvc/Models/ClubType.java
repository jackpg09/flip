package com.flip.flipmvc.Models;

public enum ClubType {

    DRIVER ("Driver"),
    FAIRWAY_DRIVER ("Fairway Driver"),
    MID_RANGE ("Mid-Range"),
    PUTTER ("Putter");

    private final String clubName;

    ClubType(String clubName) {
        this.clubName = clubName;
    }

    public String getClubName() {
        return clubName;
    }

}
