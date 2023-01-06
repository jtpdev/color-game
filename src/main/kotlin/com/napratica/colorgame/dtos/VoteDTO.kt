package com.napratica.colorgame.dtos

import com.napratica.colorgame.entities.Color
import javax.validation.constraints.NotNull

data class VoteDTO(

    @field:NotNull
    val palleteId: Int,

    @field:NotNull
    val color: Color
)
