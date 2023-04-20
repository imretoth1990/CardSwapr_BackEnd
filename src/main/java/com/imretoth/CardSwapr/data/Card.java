package com.imretoth.CardSwapr.data;

import jakarta.persistence.*;

@Entity
@Table(name = "CARDS")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String artist;
    private String description;
    private int power;
    private int toughness;
    private int manaValue;
    private String type;

    @ManyToOne
    @JoinColumn(name = "collection_id", nullable = false)
    private Collection collection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public int getManaValue() {
        return manaValue;
    }

    public void setManaValue(int manaValue) {
        this.manaValue = manaValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
