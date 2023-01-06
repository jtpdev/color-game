package com.napratica.colorgame.entities

import com.napratica.colorgame.entities.PalleteStatus.OPEN
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "palletes")
data class Pallete(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Enumerated(EnumType.STRING)
    var status: PalleteStatus = OPEN,

    @OneToMany
    @JoinColumn(name = "pallete_id")
    val votes: Collection<Vote> = listOf()
) : SuperEntity()

enum class PalleteStatus {
    OPEN, CLOSE
}
