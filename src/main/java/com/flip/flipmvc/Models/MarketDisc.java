package com.flip.flipmvc.Models;



import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class MarketDisc extends Disc {

    @Id
    @GeneratedValue
    @Column(name="disc_id")
    private int id;
    private String color;
    private String plastic;
    private String description;

    @NotNull @Range(min = 120, max = 180, message = "Weight must between 120 and 180 grams")
    private int weight;
    @NotNull @Range(min = 1, max = 13, message = "Speed must be between 1 and 13")
    private int speed;
    @NotNull @Range(min = 1, max = 7, message = "Glide must be between 1 and 7")
    private int glide;
    @NotNull @Range(min = -5, max = 1, message = "Turn must be between -5 and 1")
    private int turn;
    @NotNull @Range(min = 0, max = 6, message ="Fade must be between 0 and 6")
    private int fade;

    @ManyToOne
    private User user;

    public MarketDisc(String color, String plastic, String description, int weight, int speed, int glide, int turn, int fade) {
        super();
        this.color = color;
        this.plastic = plastic;
        this.description = description;
        this.weight = weight;
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

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
