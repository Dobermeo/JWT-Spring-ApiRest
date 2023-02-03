package com.example.proIntel.repository;

import com.example.proIntel.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository <Person, Long> {

  fun findById (id: Long?):Person?
}
