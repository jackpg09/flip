package com.flip.flipmvc.Models;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Disc {

    @NotNull
    @Size(min=1, message="Name must not be empty.")
    private String name;
    @NotNull
    @Size(min=1, message="Brand must not be empty.")
    private String brand;

    private ClubType clubType;


    public Disc(String name, String brand) {
        this();
        this.name = name;
        this.brand = brand;
    }

    public Disc() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ClubType getClubType() {
        return clubType;
    }

    public void setClubType(ClubType clubType) {
        this.clubType = clubType;
    }
}
