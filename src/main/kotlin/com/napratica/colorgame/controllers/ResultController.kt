package com.napratica.colorgame.controllers

import com.napratica.colorgame.services.ResultService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/results")
class ResultController(
    val resultService: ResultService
) {

    @GetMapping("/{palleteId}")
    fun result(@PathVariable("palleteId")  palleteId: Int) = resultService.result(palleteId)

}