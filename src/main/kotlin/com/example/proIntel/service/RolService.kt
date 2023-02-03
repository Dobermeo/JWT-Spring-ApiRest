package com.example.proIntel.service

import com.example.proIntel.model.Punctuation
import com.example.proIntel.model.Rol
import com.example.proIntel.repository.RolRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class RolService {

  @Autowired
  lateinit var rolRepository: RolRepository


  fun list(): List<Rol> {
    return rolRepository.findAll()
  }


  fun save(rol: Rol): Rol {
    try {
      rol.description?.takeIf { it.trim().isNotEmpty() }
        ?: throw Exception("fullname no debe ser vacio")


//rol.fullname?.takeIf { it.stock > 0 }
      //              ?: throw Exception("fullname no debe ser vacio")

      return rolRepository.save(rol)
    } catch (ex: Exception) {
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }

  fun update(rol: Rol): Rol {
    try {
      rolRepository.findById(rol.id)
        ?: throw Exception("Id no existe")

      return rolRepository.save(rol)
    }
    catch(ex:Exception){
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }
}
