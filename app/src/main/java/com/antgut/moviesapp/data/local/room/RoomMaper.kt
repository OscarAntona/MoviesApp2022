package com.antgut.moviesapp.data.local.room

import com.antgut.moviesapp.domain.Movie

fun Entity.toDomain(): Movie {
    return Movie(
        this.id,
        this.title,
        this.plot,
        this.genre,
        this.rating,
        this.year,
        this.poster
    )
}

fun Movie.toEntity(): Entity {
    return Entity(
        this.id,
        this.title,
        this.plot,
        this.genre,
        this.rating,
        this.year,
        this.poster
    )
}