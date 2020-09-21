package br.com.andreprado.devandoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BotaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_botao)

        val args = intent.extras
        val botao = args?.getString("valor")

        supportActionBar?.title = botao
    }
}