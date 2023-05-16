package com.imretoth.CardSwapr.db.repositories;

import com.imretoth.CardSwapr.db.data.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
