package com.company;

import java.io.Serializable;

public class Orders implements Serializable {

    private Long id;
    private int animeId;
    private String name;
    private String surname;

    public Orders(){}

    public Orders(Long id, int animesId, String name, String surname) {
        this.id = id;
        this.animeId = animesId;
        this.name = name;
        this.surname = surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnimeId(int animeId) {
        this.animeId = animeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public int getAnimeId() {
        return animeId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "IVENT " + "#" + getAnimeId() + " " + getName();
    }
}

