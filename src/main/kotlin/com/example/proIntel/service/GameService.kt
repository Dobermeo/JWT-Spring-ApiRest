package com.example.proIntel.service

import com.example.proIntel.model.Game
import com.example.proIntel.repository.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class GameService {

  @Autowired
  lateinit var gameRepository: GameRepository


  fun list(): List<Game> {
    return gameRepository.findAll()
  }


  fun save(game: Game): Game {
    try {
      game.nombrejuego?.takeIf { it.trim().isNotEmpty() }
        ?: throw Exception("fullname no debe ser vacio")


//game.fullname?.takeIf { it.stock > 0 }
      //              ?: throw Exception("fullname no debe ser vacio")

      return gameRepository.save(game)
    } catch (ex: Exception) {
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }

  fun update(game:Game):Game {
    try {
      gameRepository.findById(game.id)
        ?: throw Exception("Id no existe")

      return gameRepository.save(game)
    }
    catch(ex:Exception){
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }
}
