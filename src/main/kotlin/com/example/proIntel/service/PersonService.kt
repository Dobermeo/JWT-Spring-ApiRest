package com.example.proIntel.service

import com.example.proIntel.model.Person
import com.example.proIntel.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class PersonService {

  @Autowired
  lateinit var personRepository: PersonRepository


  fun list(): List<Person> {
    return personRepository.findAll()
  }


  fun save(person: Person): Person {
    try {
      person.cedula?.takeIf { it.trim().isNotEmpty() }
        ?: throw Exception("fullname no debe ser vacio")


//person.fullname?.takeIf { it.stock > 0 }
      //              ?: throw Exception("fullname no debe ser vacio")

      return personRepository.save(person)
    } catch (ex: Exception) {
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }

  fun update(person: Person):Person {
    try {
      personRepository.findById(person.id)
        ?: throw Exception("Id no existe")

      return personRepository.save(person)
    }
    catch(ex:Exception){
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }
}
