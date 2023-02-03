package com.example.proIntel.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank


@Entity
@Table(name="usuario")
class Usuario {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(updatable = false)
  var id: Long? = null
  @NotBlank(message="Campo obligatorio") //validate
  var clave: String? = null
  @NotBlank(message="Campo obligatorio")  //validate
  @Column(name="person_id")
  var personId: Long? = null
  @NotBlank(message="Campo obligatorio")  //validate
  @Column(name="rol_id")
  var rolId: Long? = null

}
