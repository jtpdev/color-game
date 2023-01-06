package com.napratica.colorgame.services

import com.napratica.colorgame.config.exceptions.ColorException
import com.napratica.colorgame.config.exceptions.ColorExceptionMessage
import com.napratica.colorgame.dtos.VoteDTO
import com.napratica.colorgame.entities.Pallete
import com.napratica.colorgame.entities.User
import com.napratica.colorgame.entities.Vote
import com.napratica.colorgame.repositories.PalleteRepository
import com.napratica.colorgame.repositories.UserRepository
import com.napratica.colorgame.repositories.VoteRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service


@Service
class VoteService(
    val voteRepository: VoteRepository,
    val palleteRepository: PalleteRepository,
    val userRepository: UserRepository,
) {

    fun vote(dto: VoteDTO) {

        val pallete = palleteRepository.findOpenById(dto.palleteId).orElseThrow { ColorException(ColorExceptionMessage.RESOURCE_NOT_FOUND) };

        val user = findUser();

        validateIfAlreadyVoted(user, pallete);

        voteRepository.save(
            Vote(
                pallete = pallete,
                color = dto.color,
                user = user
            )
        )
    }

    private fun validateIfAlreadyVoted(user: User, pallete: Pallete) {
        if (voteRepository.findByUserAndPallete(user, pallete).isPresent)
            throw ColorException(ColorExceptionMessage.USER_ALREADY_VOTED)
    }

    private fun findUser(): User {
        val authentication = SecurityContextHolder.getContext().authentication
        val email = (authentication.principal as org.springframework.security.core.userdetails.User).username
        return userRepository.findByEmail(email).orElseThrow { ColorException(ColorExceptionMessage.RESOURCE_NOT_FOUND) }
    }

}