package com.ludo.Snake.and.Ladder.model

import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.NoArgsConstructor


@Entity
@NoArgsConstructor
class GameConfiguration {

    @Id
    String id

    Integer boardRows
    Integer boardColumns
    Integer boardSize
    Integer diceCount
    @Convert(converter = GenericListConverter<Player>.class)
    List<Player> players = new ArrayList<>()
    @Convert(converter = GenericListConverter<Grid>.class)
    List<Grid> gridWithJump = new ArrayList<>()

    GameConfiguration() {

    }

}
