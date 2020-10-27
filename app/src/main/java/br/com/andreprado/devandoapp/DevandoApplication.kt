package br.com.andreprado.devandoapp

import android.app.Application
import java.lang.IllegalStateException

class DevandoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: DevandoApplication? = null
        fun getInstance(): DevandoApplication {
            if(appInstance == null) {
                throw IllegalStateException("Configure application no manifest")
            }
            return appInstance!!
        }
    }
}