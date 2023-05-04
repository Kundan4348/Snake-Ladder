package com.ludo.Snake.and.Ladder.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String id
    String name
}
