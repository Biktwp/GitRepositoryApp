package com.optiva.yks.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.optiva.yks.R
import com.optiva.yks.presentation.fragments.MainFragment
import com.optiva.yks.utils.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        startKoin {
            androidContext(this@MainActivity)
            modules(applicationModule)
        }
        loadMainFragment()
    }

    private fun loadMainFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container,
                MainFragment.newInstance()
            ).commit()
    }

}
