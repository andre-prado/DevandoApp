package br.com.andreprado.devandoapp

import java.io.Serializable

class Livro: Serializable {

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