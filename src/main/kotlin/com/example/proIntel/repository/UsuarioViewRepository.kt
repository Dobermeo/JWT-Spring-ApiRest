package com.example.proIntel.repository


import com.example.proIntel.model.UsuarioView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioViewRepository:JpaRepository<UsuarioView, Long> {

  fun findById(id: Long?):UsuarioView?

}
