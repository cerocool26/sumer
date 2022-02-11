package com.prueba.msprueba.mapping

import com.prueba.msprueba.model.Usuario
import com.prueba.msprueba.request.UserRequest
import com.prueba.msprueba.response.UserResponse
import com.prueba.msprueba.util.encrypt
import java.util.*

object UserMapper {

    fun requestToUser(request: UserRequest):Usuario{
        return Usuario().apply {
            name = request.name
            email = request.email
            password = encrypt(request.password)

        }
    }

    fun getUserResponse(user:Usuario):UserResponse{
        return UserResponse(
            name = user.name
        )
    }
}