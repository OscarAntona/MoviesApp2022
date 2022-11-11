package com.antgut.app.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.antgut.moviesapp.data.local.room.Dao
import com.antgut.moviesapp.data.local.room.Entity

@Database(entities = [Entity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun daoMovies(): Dao

    companion object {
        private var INSTANCE: AppDataBase? = null
        fun getDataBase(context: Context): AppDataBase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, AppDataBase::class.java, "room-db")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }

}
