package com.imretoth.CardSwapr.db.data;

import jakarta.persistence.*;
@Entity
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int power;
    private int toughness;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    private String artist;
    private String img;

    public Card() {
    }

    public Card(Long id, String name, int power, int toughness, String description, String artist, String img) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.toughness = toughness;
        this.description = description;
        this.artist = artist;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getToughness() {
        return toughness;
    }

    public String getDescription() {
        return description;
    }

    public String getArtist() {
        return artist;
    }

    public String getImg() {
        return img;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", toughness=" + toughness +
                ", description='" + description + '\'' +
                ", artist='" + artist + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
