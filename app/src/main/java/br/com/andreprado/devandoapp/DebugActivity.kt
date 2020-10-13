package br.com.andreprado.devandoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

open class DebugActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val TAG = "Exitus"
    private val className: String
        get() {
            val s = javaClass.name
            return s.substring(s.lastIndexOf("."))
        }

    var generic_layout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$className oncreate chamado")
    }

    protected fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            generic_layout,
            toolbar,
            R.string.nav_abrir,
            R.string.nav_fechar
        )
        generic_layout?.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_livros -> {
                var livros = Intent(this, LivrosActivity::class.java)
                startActivity(livros)
            }
            R.id.nav_vendas -> {
                Toast.makeText(this, "Clicou vendas", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_sair -> {
                var loginIntent = Intent(this, MainActivity::class.java)
                startActivity(loginIntent)
            }
        }
        generic_layout?.closeDrawer(GravityCompat.START)
        return true
    }
}