package com.napratica.colorgame.services

import com.napratica.colorgame.config.exceptions.ColorException
import com.napratica.colorgame.config.exceptions.ColorExceptionMessage
import com.napratica.colorgame.entities.Pallete
import com.napratica.colorgame.entities.PalleteStatus
import com.napratica.colorgame.repositories.PalleteRepository
import org.springframework.stereotype.Service

@Service
class PalleteService(
    val palleteRepository: PalleteRepository
) {

    fun open() = palleteRepository.save(Pallete()).id;

    fun close(id: Int) {
        val openedPallete = palleteRepository.findOpenById(id).orElseThrow{ ColorException(ColorExceptionMessage.RESOURCE_NOT_FOUND) };
        openedPallete.status = PalleteStatus.CLOSE
        palleteRepository.save(openedPallete);
    }

    fun lastPalleteId() = palleteRepository.lastOpenedPallete()

}