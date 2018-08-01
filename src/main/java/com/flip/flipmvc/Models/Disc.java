package com.flip.flipmvc.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Disc {

    @Id
    @GeneratedValue
    @Column(name="disc_id")
    private int id;
    private String name;
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
