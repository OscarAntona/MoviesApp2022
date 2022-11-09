package com.antgut.app.data.local.mem

class MemDataStore<M> {

    private val dataStore: MutableMap<String, M> = mutableMapOf()

    fun put(id: String, model: M) {
        dataStore.put(id, model)
    }

    fun get(id: String) = dataStore[id]

    fun getAll() = dataStore.map{entry ->
        entry.value
    }
}