package br.com.andreprado.devandoapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Livros")
class Livro: Serializable {

    @PrimaryKey
    var id:Long = 0
    var titulo = ""
    var autor = ""
    var editora = ""
    var isbn = ""
    var categoria = ""
    var preco = ""
    var estoque = ""
    var foto = ""

    override fun toString(): String {
        return "Livro(nome=$titulo)"
    }
}