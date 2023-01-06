package com.napratica.colorgame.repositories

import com.napratica.colorgame.dtos.ResultDTO
import com.napratica.colorgame.entities.Pallete
import com.napratica.colorgame.entities.User
import com.napratica.colorgame.entities.Vote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional
import java.util.UUID

interface PalleteRepository: JpaRepository<Pallete, Int> {

    @Query(
        """
            select p from Pallete p
            where p.status = com.napratica.colorgame.entities.PalleteStatus.OPEN
            and p.id = ?1
        """
    )
    fun findOpenById(id: Int) : Optional<Pallete>

    @Query(
        """
            select p.id from Pallete p
            where p.status = com.napratica.colorgame.entities.PalleteStatus.CLOSE
            and p.id = ?1
        """
    )
    fun findClosedById(palleteId: Int) : Optional<Pallete>

    @Query(
        """
            select new com.napratica.colorgame.dtos.ResultDTO(v.color, count(v)) from Pallete p
            inner join p.votes v
            where p.status = com.napratica.colorgame.entities.PalleteStatus.CLOSE
            and p.id = ?1
            group by v.color
        """
    )
    fun result(id: Int) : Optional<List<ResultDTO>>

    @Query(
        """
            select p.id from Pallete p
            where p.status = com.napratica.colorgame.entities.PalleteStatus.OPEN
            order by created_at desc
        """
    )
    fun lastOpenedPallete() : Int?

}

interface VoteRepository: JpaRepository<Vote, Int> {
    @Query(
        """
            select v from Vote v
            where v.user = ?1
            and v.pallete = ?2
        """
    )
    fun findByUserAndPallete(user: User, pallete: Pallete) : Optional<Vote>
}


interface UserRepository: JpaRepository<User, UUID> {

    @Query(
        """
            select u from User u
            where u.email = ?1
        """
    )
    fun findByEmail(email: String) : Optional<User>

}