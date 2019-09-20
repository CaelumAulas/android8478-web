package br.com.caelum.twittelumappweb

import android.app.Application
import br.com.caelum.twittelumappweb.di.datasources
import br.com.caelum.twittelumappweb.di.network
import br.com.caelum.twittelumappweb.di.repositories
import br.com.caelum.twittelumappweb.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TwittelumApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TwittelumApplication)
            modules(arrayListOf(network, datasources, repositories, viewModels))
        }
    }


}