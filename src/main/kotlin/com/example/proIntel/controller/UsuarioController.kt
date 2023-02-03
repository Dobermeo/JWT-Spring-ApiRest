package com.example.proIntel.controller

import com.example.proIntel.model.Usuario
import com.example.proIntel.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/usuario")
class UsuarioController {

  @Autowired
  lateinit var usuarioService: UsuarioService

  @GetMapping
  fun list(): List<Usuario> {
    return usuarioService.list()
  }

  @GetMapping("/rol")
  fun listWithRol ():ResponseEntity<*>{
    return ResponseEntity(usuarioService.listWithRol(), HttpStatus.OK)
  }

  @PostMapping
  fun save(@RequestBody @Valid usuario: Usuario): ResponseEntity<Usuario> {
    return ResponseEntity(usuarioService.save(usuario), HttpStatus.OK)
  }

  @PutMapping
  fun update (@RequestBody usuario:Usuario):ResponseEntity<Usuario>{
    return ResponseEntity(usuarioService.update(usuario), HttpStatus.OK)
  }
}
