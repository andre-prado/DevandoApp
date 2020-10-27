package br.com.andreprado.devandoapp

import androidx.room.Room

object DataBaseManager {
    private var dbInstance:DevandoDataBase
    init {
        val contexto = DevandoApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(contexto, DevandoDataBase::class.java, "Devando.sqlite").build()
    }

    fun getLivroDAO(): LivroDAO {
        return dbInstance.livroDAO()
    }
}