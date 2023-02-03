package com.example.proIntel.repository;

import com.example.proIntel.model.Punctuation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PunctuationRepository: JpaRepository <Punctuation, Long> {

  fun findById (id: Long?):Punctuation?
}
