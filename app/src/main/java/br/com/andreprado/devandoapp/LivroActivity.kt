package br.com.andreprado.devandoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_livro.*
import kotlinx.android.synthetic.main.toolbar.*

class LivroActivity : DebugActivity() {
    var livro: Livro? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livro)

        livro = intent.getSerializableExtra("livro") as Livro

        setSupportActionBar(toolbar)

        supportActionBar?.title = livro?.titulo

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tituloLivro.text = livro?.titulo
        autorLivro.text = livro?.autor
        Picasso.with(this).load(livro?.foto).fit().into(imagemLivro,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}

                override fun onError() {}
            })
    }
}