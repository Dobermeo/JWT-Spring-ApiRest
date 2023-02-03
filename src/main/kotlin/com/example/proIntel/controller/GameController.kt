package com.example.proIntel.controller

import com.example.proIntel.model.Game
import com.example.proIntel.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/game")
class GameController {

  @Autowired
  lateinit var gameService: GameService

  @GetMapping
  fun list(): List<Game> {
    return gameService.list()
  }

  @PostMapping
  fun save(@RequestBody @Valid game: Game): ResponseEntity<Game> {
    return ResponseEntity(gameService.save(game), HttpStatus.OK)
  }

  @PutMapping
  fun update (@RequestBody game:Game):ResponseEntity<Game>{
    return ResponseEntity(gameService.update(game), HttpStatus.OK)
  }
}

