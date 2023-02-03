package com.example.proIntel.repository;

import com.example.proIntel.model.Rol
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RolRepository: JpaRepository <Rol, Long> {

  fun findById (id: Long?):Rol?
}
