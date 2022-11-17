package com.antgut.moviesapp.data.local.memory

import com.antgut.app.data.local.mem.MemDataStore
import com.antgut.moviesapp.data.local.LocalDataRepository
import com.antgut.moviesapp.domain.Movie

class MemoryLocalDataSource(val memoryDataStore: MemDataStore<Movie>) : LocalDataRepository {


    override fun getMovies(): List<Movie> {
        return memoryDataStore.getAll()
    }

    override fun getMovie(id: String): Movie? {
        return memoryDataStore.get(id)
    }

    override fun saveMovies(list: List<Movie>) {
        list.forEach {
            memoryDataStore.put(it.id, it)
        }
    }

}