package br.com.andreprado.devandoapp

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object LivroService {
    val host = "https://andreprado.pythonanywhere.com"
    val TAG = "WS_Devando"

    fun getLivros(): List<Livro> {
        val url = "$host/livros"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)

        return parserJson<List<Livro>>(json)

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}