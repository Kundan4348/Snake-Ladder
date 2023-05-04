package com.ludo.Snake.and.Ladder.controller

import com.ludo.Snake.and.Ladder.model.GameConfiguration
import com.ludo.Snake.and.Ladder.service.GameConfigurationService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/configure")
class GameConfigurationController {

    @Autowired
    GameConfigurationService gameConfigurationService


//    @GetMapping("/game")
//    static Model gameConfigSetup(Model model) {
//        return "add-gameConfiguration"
//    }

    @PostMapping("/game")
    String gameConfigSetup( @RequestBody GameConfiguration gameConfiguration) {
        log.info("Configuration Received")
        return gameConfigurationService.saveGameConfig(gameConfiguration)
    }


}
