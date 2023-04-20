package com.imretoth.CardSwapr.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COLLECTIONS")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String category;
    @OneToMany(mappedBy = "collection")
    private List<Card> cards;

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
