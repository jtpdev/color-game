package com.napratica.colorgame.dtos

import com.napratica.colorgame.entities.Color

data class ResultDTO(
    val color: Color,
    val count: Long
)