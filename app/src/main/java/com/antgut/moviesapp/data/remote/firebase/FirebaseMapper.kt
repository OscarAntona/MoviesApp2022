package com.antgut.moviesapp.data.remote.firebase

import com.antgut.moviesapp.domain.Movie

fun FirebaseModels.toDomain(): Movie {
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