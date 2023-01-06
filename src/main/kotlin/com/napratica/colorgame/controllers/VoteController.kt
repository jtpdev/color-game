package com.napratica.colorgame.controllers

import com.napratica.colorgame.dtos.VoteDTO
import com.napratica.colorgame.services.VoteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/votes")
class VoteController (
    val voteService: VoteService
) {

    @PostMapping()
    fun vote(@RequestBody dto: VoteDTO): ResponseEntity<VoteDTO> {
        voteService.vote(dto);
        return ResponseEntity.ok(dto)
    }
}