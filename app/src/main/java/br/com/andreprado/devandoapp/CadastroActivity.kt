package br.com.andreprado.devandoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        supportActionBar?.title = "Cadastro"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        livroSalvar.setOnClickListener{
            val livro = Livro()
            livro.autor = livroAutor.text.toString()
            livro.categoria = livroCategoria.text.toString()
            livro.editora = livroEditora.text.toString()
            livro.estoque = livroEstoque.text.toString()
            livro.foto = livroFoto.text.toString()
            livro.isbn = livroISBN.text.toString()
            livro.preco = livroPreco.text.toString()
            livro.titulo = livroTitulo.text.toString()

            Thread {
                LivroService.setLivros(livro)
                runOnUiThread { finish() }
            }.start()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item?.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}