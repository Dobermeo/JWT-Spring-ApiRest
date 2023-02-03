package com.example.proIntel.service

import com.example.proIntel.model.Punctuation
import com.example.proIntel.model.Usuario
import com.example.proIntel.model.UsuarioView
import com.example.proIntel.repository.UsuarioRepository
import com.example.proIntel.repository.UsuarioViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class UsuarioService {

  @Autowired
  lateinit var usuarioRepository: UsuarioRepository
  lateinit var usuarioViewRepository: UsuarioViewRepository


  fun list(): List<Usuario> {
    return usuarioRepository.findAll()
  }

  fun listWithRol(): List<UsuarioView> {
    return usuarioViewRepository.findAll()
  }

  fun save(usuario: Usuario): Usuario {
    try {
      usuario.clave?.takeIf { it.trim().isNotEmpty() }
        ?: throw Exception("fullname no debe ser vacio")


//usuario.fullname?.takeIf { it.stock > 0 }
      //              ?: throw Exception("fullname no debe ser vacio")

      return usuarioRepository.save(usuario)
    } catch (ex: Exception) {
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }

  fun update(usuario: Usuario): Usuario {
    try {
      usuarioRepository.findById(usuario.id)
        ?: throw Exception("Id no existe")

      return usuarioRepository.save(usuario)
    }
    catch(ex:Exception){
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }
}
