package com.optiva.yks

import android.app.Application
import android.content.Context
import com.optiva.yks.utils.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin {
            androidContext(this@App)
            modules(applicationModule)
        }

    }

}