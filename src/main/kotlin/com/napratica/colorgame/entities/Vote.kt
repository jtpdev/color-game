package com.napratica.colorgame.entities

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(
    name = "votes",
    uniqueConstraints = [
        UniqueConstraint( columnNames = ["pallete_id", "user_id" ] )
    ]
)
data class Vote(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "pallete_id")
    val pallete: Pallete,

    @Enumerated(EnumType.STRING)
    val color: Color,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
): SuperEntity()

enum class Color(
    hex: String
) {
    RED("#FF0000"),
    CYAN("#00FFFF"),
    BLUE("#0000FF"),
    PURPLE("#800080"),
    YELLOW("#FFFF00"),
    GREEN("#00FF00"),
    ORANGE("#00FF00"),
    PINK("##FFC0CB");
}
