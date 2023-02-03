package com.example.proIntel.service

import com.example.proIntel.model.Punctuation
import com.example.proIntel.repository.PunctuationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class PunctuationService {

  @Autowired
  lateinit var punctuationRepository: PunctuationRepository


  fun list(): List<Punctuation> {
    return punctuationRepository.findAll()
  }


  fun save(punctuation: Punctuation): Punctuation {
    try {
      punctuation.puntuacion?.takeIf { it.toString().isNotEmpty() }
        ?: throw Exception("fullname no debe ser vacio")


//punctuation.fullname?.takeIf { it.stock > 0 }
      //              ?: throw Exception("fullname no debe ser vacio")

      return punctuationRepository.save(punctuation)
    } catch (ex: Exception) {
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }

  fun update(punctuation: Punctuation):Punctuation {
    try {
      punctuationRepository.findById(punctuation.id)
        ?: throw Exception("Id no existe")

      return punctuationRepository.save(punctuation)
    }
    catch(ex:Exception){
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }
}
