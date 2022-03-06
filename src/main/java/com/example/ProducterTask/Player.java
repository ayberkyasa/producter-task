package com.example.ProducterTask;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
     enum position {PG, SG, SF, PF, C};

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private String surname;
    private position position;

    public Player() {

    }

    public Player(String name, String surname, Player.position position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Player.position getPosition() {
        return position;
    }

    public void setPosition(Player.position position) {
        this.position = position;
    }
}
