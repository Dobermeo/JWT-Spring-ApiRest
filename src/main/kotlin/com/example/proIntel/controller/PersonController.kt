package com.example.proIntel.controller

import com.example.proIntel.model.Person
import com.example.proIntel.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/person")
class PersonController {

  @Autowired
  lateinit var personService: PersonService

  @GetMapping
  fun list(): List<Person> {
    return personService.list()
  }

  @PostMapping
  fun save(@RequestBody @Valid person: Person): ResponseEntity<Person> {
    return ResponseEntity(personService.save(person), HttpStatus.OK)
  }

  @PutMapping
  fun update (@RequestBody person:Person):ResponseEntity<Person>{
    return ResponseEntity(personService.update(person), HttpStatus.OK)
  }
}
