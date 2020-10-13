package br.com.andreprado.devandoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_livros.*
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.activity_tela_inicial.layoutMenuLateral
import kotlinx.android.synthetic.main.toolbar.*

class LivrosActivity : DebugActivity() {

    private var livros = listOf<Livro>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livros)

        this.generic_layout = layoutMenuLateral

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Livros"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recyclerLivros?.layoutManager = LinearLayoutManager(this)
        recyclerLivros?.itemAnimator = DefaultItemAnimator()
        recyclerLivros?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskLivros()
    }

    fun taskLivros() {
        livros = LivroService.getLivros()

        recyclerLivros?.adapter = LivroAdapter(livros) {onClickLivro(it)}
    }

    fun onClickLivro(livro: Livro) {
        Toast.makeText(this, "Clicou disciplina ${livro.titulo}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LivroActivity::class.java)
        intent.putExtra("livro", livro)
        startActivity(intent)
    }

}