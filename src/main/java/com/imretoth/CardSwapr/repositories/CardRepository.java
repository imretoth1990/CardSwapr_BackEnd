package com.imretoth.CardSwapr.repositories;

import com.imretoth.CardSwapr.data.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
