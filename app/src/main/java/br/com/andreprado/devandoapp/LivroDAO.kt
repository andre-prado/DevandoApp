package br.com.andreprado.devandoapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LivroDAO {

    @Query("select * from Livros where id = :id")
    fun getById(id: Long): Livro?

    @Query("select * from Livros")
    fun findAll(): List<Livro>

    @Insert
    fun insert(livro: Livro)

    @Delete
    fun delete(livro: Livro)
}