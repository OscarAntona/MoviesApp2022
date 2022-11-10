package com.antgut.moviesapp.data.remote.retrofit

import com.antgut.moviesapp.domain.Movie

fun ApiModel.toDomain(): Movie {
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