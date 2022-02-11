package com.prueba.msprueba.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class HGException(
    code:String = "",
    message:String? = null,
    status:HttpStatus = HttpStatus.BAD_REQUEST
):RuntimeException() {
    var code = code
    override var message = message
    var status = status
}