package com.flip.flipmvc.Models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@Entity
public class MarketDisc extends Disc {

    @Id
    @GeneratedValue
    @Column(name = "disc_id")
    private int id;
    private String color;
    private String plastic;
    private String description;

    @NotNull
    @Range(min = 120, max = 180, message = "Regulation is between 120 and 180 grams")
    private int weight;

    private Speed speed;
    private Glide glide;
    private Turn turn;
    private Fade fade;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "cartDisc")
    private List<User> usersCart;

    public MarketDisc(String color, String plastic, String description, int weight,
                      Speed speed, Glide glide, Turn turn, Fade fade) {
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

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Glide getGlide() {
        return glide;
    }

    public void setGlide(Glide glide) {
        this.glide = glide;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public Fade getFade() {
        return fade;
    }

    public void setFade(Fade fade) {
        this.fade = fade;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
