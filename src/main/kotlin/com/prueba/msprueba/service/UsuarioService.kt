package com.prueba.msprueba.service

import com.prueba.msprueba.mapping.UserMapper
import com.prueba.msprueba.repository.UserRepository
import com.prueba.msprueba.request.UserRequest
import com.prueba.msprueba.request.UserRequestLogin
import com.prueba.msprueba.response.UserResponse
import com.prueba.msprueba.validator.UserValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UsuarioService {
    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var userValidator: UserValidator

    fun createUser(requestUser: UserRequest): UserResponse {
        val usuario = UserMapper.requestToUser(requestUser)
        userRepository.save(usuario)

        return UserMapper.getUserResponse(usuario)
    }

    fun login(requestUserLogin : UserRequestLogin):Boolean{
         userValidator.userExists(requestUserLogin.email)

        return userValidator.userLogin(requestUserLogin)
    }
}