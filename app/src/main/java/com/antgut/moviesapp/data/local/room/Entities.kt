package com.antgut.moviesapp.data.local.room

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

const val TABLE_NAME = "movies"
const val ID = "id"

@androidx.room.Entity(tableName = TABLE_NAME)
data class Entity(
    @PrimaryKey @ColumnInfo(name = ID) val id:String,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "plot") val plot:String,
    @ColumnInfo(name = "genre") val genre:String,
    @ColumnInfo(name = "rating") val rating:String,
    @ColumnInfo(name = "year") val year:String,
    @ColumnInfo(name = "poster") val poster:String
)