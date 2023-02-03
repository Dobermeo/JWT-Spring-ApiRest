package com.example.proIntel.controller

import com.example.proIntel.model.Rol
import com.example.proIntel.service.RolService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/rol")
class RolController {

  @Autowired
  lateinit var rolService: RolService

  @GetMapping
  fun list(): List<Rol> {
    return rolService.list()
  }

  @PostMapping
  fun save(@RequestBody @Valid rol: Rol): ResponseEntity<Rol> {
    return ResponseEntity(rolService.save(rol), HttpStatus.OK)
  }

  @PutMapping
  fun update (@RequestBody rol:Rol):ResponseEntity<Rol>{
    return ResponseEntity(rolService.update(rol), HttpStatus.OK)
  }
}
