package com.example.proIntel.controller

import com.example.proIntel.model.Punctuation
import com.example.proIntel.service.PunctuationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/punctuation")
class PunctuationController {

  @Autowired
  lateinit var punctuationService: PunctuationService

  @GetMapping
  fun list(): List<Punctuation> {
    return punctuationService.list()
  }

  @PostMapping
  fun save(@RequestBody @Valid punctuation: Punctuation): ResponseEntity<Punctuation> {
    return ResponseEntity(punctuationService.save(punctuation), HttpStatus.OK)
  }

  @PutMapping
  fun update (@RequestBody punctuation:Punctuation):ResponseEntity<Punctuation>{
    return ResponseEntity(punctuationService.update(punctuation), HttpStatus.OK)
  }
}
