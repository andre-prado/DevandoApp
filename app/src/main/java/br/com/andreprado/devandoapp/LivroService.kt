package br.com.andreprado.devandoapp

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object LivroService {
    val host = "https://andreprado.pythonanywhere.com"
    val TAG = "WS_Devando"

    fun existeLivro(livro: Livro): Boolean {
        val dao = DataBaseManager.getLivroDAO()
        return dao.getById(livro.id) != null
    }

    fun saveOffline(livro: Livro): Boolean {
        val dao = DataBaseManager.getLivroDAO()
        if ( !existeLivro(livro) ) {
            dao.insert(livro)
        }
        return true
    }

    fun getLivros(context: Context): List<Livro> {
        var livros = ArrayList<Livro>()
        if ( AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/livros"
            val json = HttpHelper.get(url)

            Log.d(TAG, json)

            livros = parserJson(json)
            for(l in livros) {
                saveOffline(l)
            }
            return livros
        } else {
            val dao = DataBaseManager.getLivroDAO()
            val livros = dao.findAll()
            return livros
        }
    }

    fun setLivros(livro: Livro, context: Context) {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val json = GsonBuilder().create().toJson(livro)
            HttpHelper.post("$host/livros", json)
        } else {
            DataBaseManager.getLivroDAO().insert(livro)
        }
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}