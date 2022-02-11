package com.prueba.msprueba.repository

import com.prueba.msprueba.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<Usuario,Long> {
    @Query("SELECT u FROM Usuario AS u WHERE u.code = :code")
    fun getByCode(code:UUID): Usuario?

    @Query("SELECT u FROM Usuario AS u WHERE u.email = :email")
    fun getUserByEmail(email:String):Usuario?
}