package com.napratica.colorgame.dtos

import com.napratica.colorgame.entities.User

fun CreateUserDTO.toEntity() = User(
    email = this.email,
    password = this.password
)