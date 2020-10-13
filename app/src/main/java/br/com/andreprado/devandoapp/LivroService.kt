package br.com.andreprado.devandoapp

object LivroService {

    fun getLivros(): List<Livro> {
        val livros = mutableListOf<Livro>()

        for(i in 1..10) {
            val l = Livro()
            l.autor = "Autor $i"
            l.categoria = "Categoria $i"
            l.editora = "Editora $i"
            l.estoque = "Estoque $i"
            l.foto = "https://static.vecteezy.com/system/resources/previews/000/292/434/non_2x/blank-book-on-white-background-vector.jpg"
            l.isbn = "ISBN $i"
            l.preco = "Preco $i"
            l.titulo = "Titulo $i"

            livros.add(l)
        }
        return livros
    }
}