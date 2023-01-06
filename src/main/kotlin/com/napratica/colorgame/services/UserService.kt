package com.napratica.colorgame.services

import com.napratica.colorgame.config.exceptions.ColorException
import com.napratica.colorgame.config.exceptions.ColorExceptionMessage
import com.napratica.colorgame.dtos.CreateUserDTO
import com.napratica.colorgame.dtos.UserDTO
import com.napratica.colorgame.dtos.toEntity
import com.napratica.colorgame.repositories.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder
) {

    fun create(dto: CreateUserDTO): UserDTO {
        validateIfEmailAlreadyExists(dto)

        val user = dto.toEntity()
        user.password = passwordEncoder.encode(user.password)

        val savedUser = userRepository.save(user)
        return UserDTO(savedUser.email);
    }

    private fun validateIfEmailAlreadyExists(dto: CreateUserDTO) {
        if (userRepository.findByEmail(dto.email).isPresent)
            throw ColorException(ColorExceptionMessage.USER_ALREADY_EXISTS)
    }

}