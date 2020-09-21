package br.com.andreprado.devandoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val intent = Intent(this, BotaoActivity::class.java)
        val params = Bundle()

        button_cadastro.setOnClickListener{
            val textoBotao = button_cadastro.text.toString()
            params.putString("valor", textoBotao)
            intent.putExtras(params)
            startActivity(intent)
        }
        button_alterar.setOnClickListener{
            val textoBotao = button_alterar.text.toString()
            params.putString("valor", textoBotao)
            intent.putExtras(params)
            startActivity(intent)
        }
        button_realizar.setOnClickListener{
            val textoBotao = button_realizar.text.toString()
            params.putString("valor", textoBotao)
            intent.putExtras(params)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                Toast.makeText(applicationContext, newText, Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(applicationContext, query, Toast.LENGTH_LONG).show()
                return false
            }

        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId

        if (id == R.id.action_adicionar) {
            var cadastroIntent = Intent(this, CadastroActivity::class.java)
            startActivity(cadastroIntent)
        } else if (id == R.id.action_sair) {
            var loginIntent = Intent(this, MainActivity::class.java)
            startActivity(loginIntent)
        }
        return super.onOptionsItemSelected(item)
    }

}