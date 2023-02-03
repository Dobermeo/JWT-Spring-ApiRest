package com.example.proIntel.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank


@Entity
@Table(name="person")
class Person {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(updatable = false)
  var id: Long? = null
  @NotBlank(message="Campo obligatorio") //validate
  var apellidos: String? = null
  @NotBlank(message="Campo obligatorio")  //validate
  var cedula: String? = null
  var email: String? = null
  @NotBlank(message="Campo obligatorio")  //validate
  var nombres: String? = null
  var telefono: String? = null
}
