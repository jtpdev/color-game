package com.napratica.colorgame.services

import com.napratica.colorgame.repositories.PalleteRepository
import org.springframework.stereotype.Service

@Service
class ResultService(
    val palleteRepository: PalleteRepository
) {

    fun result(palleteId: Int) =
            palleteRepository.result(palleteId).orElse(listOf())
}