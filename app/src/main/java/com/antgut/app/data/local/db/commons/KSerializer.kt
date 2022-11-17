package com.antgut.app.data.local.db.commons

interface KSerializer {
    fun <T> toJson(src: T, classObject: Class<T>): String
    fun <T> fromJson(string: String?, classObject: Class<T>): T
}

