package com.flip.flipmvc.Models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_-]{4,11}", message = "Invalid username")
    private String username;

    @NotNull
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<MarketDisc> discs = new ArrayList<>();

    @ManyToMany
    private List<MarketDisc> cartDisc = new ArrayList<>();



    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = hashPassword(password);
    }

    public int getId() { return id; }

    public String getUsername() {
        return username;
    }

    private static String hashPassword(String password) {
        return encoder.encode(password);
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public List<MarketDisc> getDiscs() { return discs; }

    public List<MarketDisc> getCartDiscs() { return cartDisc; }

    public void addCartDisc(MarketDisc disc) {cartDisc.add(disc);}

    public void removeCartDisc(MarketDisc disc) {cartDisc.remove(disc);}
}
