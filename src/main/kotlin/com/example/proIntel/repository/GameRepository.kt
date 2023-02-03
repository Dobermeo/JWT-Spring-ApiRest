package com.example.proIntel.repository;

import com.example.proIntel.model.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameRepository: JpaRepository <Game, Long> {

  fun findById (id: Long?):Game?
}
