package com.flip.flipmvc.Models;

import javax.persistence.*;


@Entity
public class LostDisc extends Disc {

    @Id
    @GeneratedValue
    @Column(name="disc_id")
    private int id;
    private String phNumber;
    private String pdgaNumber;

    @ManyToOne
    private User user;

    public LostDisc(String phNumber, String pdgaNumber){
        super();
        this.phNumber = phNumber;
        this.pdgaNumber = pdgaNumber;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getPhNumber() { return phNumber; }

    public void setPhNumber(String phNumber) { this.phNumber = phNumber; }

    public String getPdgaNumber() { return pdgaNumber; }

    public void setPdgaNumber(String pdgaNumber) { this.pdgaNumber = pdgaNumber; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
