package com.prueba.msprueba.validator

import com.prueba.msprueba.exceptions.HGException
import com.prueba.msprueba.model.Usuario
import com.prueba.msprueba.repository.UserRepository
import com.prueba.msprueba.request.UserRequestLogin
import com.prueba.msprueba.util.decrytp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
class UserValidator {

    @Autowired
    lateinit var userRepository: UserRepository

    fun userExists(email:String):Usuario{
        val usuario:Usuario? = userRepository.getUserByEmail(email)
        if(usuario != null){
            return usuario
        }else{
            throw HGException(
                code = "user-empty",
                message = "User not Found",
                status = HttpStatus.BAD_REQUEST
            )
        }
    }

    fun userLogin(userRequestLogin: UserRequestLogin):Boolean{
        val usuario:Usuario = userRepository.getUserByEmail(userRequestLogin.email)!!
        val password = decrytp(usuario.password)
        println(password)
        if(userRequestLogin.email == usuario.email && password == userRequestLogin.password){
            return true
        }
        return false
    }

}