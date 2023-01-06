package com.napratica.colorgame.controllers

import com.napratica.colorgame.dtos.CreateUserDTO
import com.napratica.colorgame.dtos.UserDTO
import com.napratica.colorgame.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/signup")
class SignupController(
    val userService: UserService
) {

    @PostMapping
    fun signup(@RequestBody @Valid user: CreateUserDTO): ResponseEntity<UserDTO> {
        val userCreated = userService.create(user)
        return ResponseEntity.created(URI("")).body(userCreated)
    }

}