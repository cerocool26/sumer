package com.prueba.msprueba.controller

import com.prueba.msprueba.request.UserRequest
import com.prueba.msprueba.request.UserRequestLogin
import com.prueba.msprueba.response.UserResponse
import com.prueba.msprueba.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/ms-prueba")
class UserController {
    @Autowired
    lateinit var userService: UsuarioService

    @PostMapping("/register")
    fun createUser(reques: HttpServletRequest,@RequestBody userResquest: UserRequest): UserResponse {

        return userService.createUser(userResquest)
    }

    @PostMapping("/login")
    fun loginUser(reques: HttpServletRequest,@RequestBody userResquest: UserRequestLogin):Boolean {
        return userService.login(userResquest)
    }

}