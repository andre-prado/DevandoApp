package br.com.andreprado.devandoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_livros.*
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        campoUsuario.setText(Prefs.getString("lembrarNome"))
        campoSenha.setText(Prefs.getString("lembrarSenha"))
        checkLembrar.isChecked = Prefs.getBoolean("lembrar")

        campoImagem.setImageResource(R.drawable.livros)

        botaoLogin.setOnClickListener {
            val valorUsuario = campoUsuario.text.toString()
            val valorSenha = campoSenha.text.toString()
            //Toast.makeText(this, "Usuário: $valorUsuario, Senha: $valorSenha", Toast.LENGTH_LONG).show()

            Prefs.setBoolean("lembrar", checkLembrar.isChecked)
            if (checkLembrar.isChecked) {
                Prefs.setString("lembrarNome", valorUsuario)
                Prefs.setString("lembrarSenha", valorSenha)
            } else {
                Prefs.setString("lembrarNome", "")
                Prefs.setString("lembrarSenha", "")
            }

            if (valorUsuario == "aluno" && valorSenha == "impacta") {
                var intent = Intent(this, TelaInicialActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
            }
        }
    }
}