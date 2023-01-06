package com.napratica.colorgame.config.exceptions

import org.springframework.http.HttpStatus

class ColorException(val colorMessage: ColorExceptionMessage) : RuntimeException(colorMessage.message)

enum class ColorExceptionMessage(val status: HttpStatus, val message: String) {
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found"),
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "User already exist"),
    USER_ALREADY_VOTED(HttpStatus.BAD_REQUEST, "User already voted");
}