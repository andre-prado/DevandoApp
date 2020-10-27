package br.com.andreprado.devandoapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Livro::class), version = 1)
abstract class DevandoDataBase: RoomDatabase() {
    abstract fun livroDAO(): LivroDAO
}