package com.prueba.msprueba.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*
import javax.persistence.*

@Table(name = "usuario")
@Entity
class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id :Long = 0

    @Column(name = "code", unique = true)
    var code: UUID = UUID.randomUUID()

    @Column(name = "name")
    var name :String = ""

    @Column(name = "email")
    var email:String = ""

    @Column(name = "password")
    var password:String = ""

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

    @Column(name = "updated_at")
    var updateAt: LocalDate? = null
}