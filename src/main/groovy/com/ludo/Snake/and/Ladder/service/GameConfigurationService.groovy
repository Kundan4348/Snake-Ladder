package com.ludo.Snake.and.Ladder.service

import com.ludo.Snake.and.Ladder.model.GameConfiguration
import com.ludo.Snake.and.Ladder.repository.GameConfigurationRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.stream.IntStream

@Slf4j
@Service
class GameConfigurationService {

    @Autowired
    GameConfigurationRepository gameConfigurationRepository

    String saveGameConfig(GameConfiguration gameConfiguration) {
        Random random = new Random()
        Integer randomNumberGenerator = random.ints(1,0, Integer.MAX_VALUE).findFirst().getAsInt()
        String gameConfigId = "conf_" + randomNumberGenerator.toString()
        log.info("gameConfigId: ${gameConfigId}")

        try {
            gameConfiguration.setId(gameConfigId)
            gameConfiguration.boardSize = gameConfiguration.boardRows * gameConfiguration.boardColumns
            gameConfigurationRepository.save(gameConfiguration)
        } catch (Exception ex) {
            log.info("Exception occurred while saving game config: Exception [{}]", ex.getLocalizedMessage())
        }

        return "Game Id: " + gameConfiguration.id
    }
}
