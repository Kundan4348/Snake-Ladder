package com.ludo.Snake.and.Ladder.model

import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
class Grid {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String id
    Integer position
    Integer jumpStart
    Integer jumpEnd
    @Convert(converter = GenericListConverter<Player>.class)
    List<Player> activePlayers
}
