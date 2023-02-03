package com.example.proIntel.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank


@Entity
@Table(name="punctuation")
class Punctuation {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(updatable = false)
  var id: Long? = null
  @NotBlank(message="Campo obligatorio") //validate
  var puntuacion: Long? = null
  @NotBlank(message="Campo obligatorio")  //validate
  @Column(name="game_id")
  var gameId: Long? = null
  @NotBlank(message="Campo obligatorio")  //validate
  @Column(name="usuario_id")
  var usuarioId: Long? = null

}
