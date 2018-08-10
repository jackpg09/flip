package com.flip.flipmvc.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MarketDisc extends Disc {

    @Id
    @GeneratedValue
    @Column(name="disc_id")
    private int id;
    private String color;
    private String plastic;
    private String description;
    private int weight;
    private int speed;
    private int glide;
    private int turn;
    private int fade;

    public MarketDisc(String color, String plastic, String description, int speed, int glide, int turn, int fade) {
        super();
        this.color = color;
        this.plastic = plastic;
        this.description = description;
        this.speed = speed;
        this.glide = glide;
        this.turn = turn;
        this.fade = fade;
    }

    public MarketDisc(){
        super();
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlastic() {
        return plastic;
    }

    public void setPlastic(String plastic) {
        this.plastic = plastic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() { return weight; }

    public void setWeight(int weight) { this.weight = weight; }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGlide() {
        return glide;
    }

    public void setGlide(int glide) {
        this.glide = glide;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getFade() {
        return fade;
    }

    public void setFade(int fade) {
        this.fade = fade;
    }
}
