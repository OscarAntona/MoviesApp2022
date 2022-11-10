package com.antgut.moviesapp.data.local.xml

import android.content.SharedPreferences
import com.antgut.app.data.local.db.commons.KSerializer
import com.antgut.moviesapp.data.local.LocalDataRepository
import com.antgut.moviesapp.domain.Movie

class XmlLocalDataSource(
    private val sharedPref: SharedPreferences,
    private val kserializer: KSerializer
) :
    LocalDataRepository {

    private val editor: SharedPreferences.Editor = sharedPref.edit()

    override fun getMovie(id: String): Movie {
        return sharedPref.getString(id, null).let {
            kserializer.fromJson(it, Movie::class.java)
        }
    }

    override fun getMovies(): List<Movie> {
        val list = mutableListOf<Movie>()
        sharedPref.all.forEach {
            editor.apply {
                list.add(kserializer.fromJson(it.value as String, Movie::class.java))
            }.apply()
        }
        return list
    }

    override fun saveMovies(list: List<Movie>) {
        list.forEach {
            editor.putString(it.id, kserializer.toJson(it, Movie::class.java))
        }
        editor.apply()
    }

}