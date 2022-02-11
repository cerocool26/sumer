package com.prueba.msprueba.util


import java.util.*


    fun encrypt(password:String):String{
        val pass = password.toByteArray()
        val data = Base64.getEncoder().encodeToString(pass)
        return data
    }

    fun decrytp(dataEncrypt:String):String{
        val data =  Base64.getDecoder().decode(dataEncrypt)
        return String(data,Charsets.UTF_8)
    }
