package com.napratica.colorgame.controllers

import com.napratica.colorgame.services.PalleteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/palletes")
class PalleteController(
    val palleteService: PalleteService
) {

    @GetMapping()
    fun available(): ResponseEntity<Int> {
        return ResponseEntity.ok(palleteService.lastPalleteId())
    }

}