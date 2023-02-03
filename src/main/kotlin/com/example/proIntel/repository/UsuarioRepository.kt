package com.example.proIntel.repository;

import com.example.proIntel.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository <Usuario, Long> {

  fun findById (id: Long?):Usuario?
}
