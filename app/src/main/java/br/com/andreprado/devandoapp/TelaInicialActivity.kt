package br.com.andreprado.devandoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        this.generic_layout = layoutMenuLateral

        val intent = Intent(this, BotaoActivity::class.java)
        val params = Bundle()

        button_cadastro.setOnClickListener{
            var cadastroIntent = Intent(this, CadastroActivity::class.java)
            startActivity(cadastroIntent)
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

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Exitus"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
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