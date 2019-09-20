package br.com.caelum.twittelumappweb.di

import br.com.caelum.twittelumappweb.data.LoginStorage
import br.com.caelum.twittelumappweb.network.LoginApi
import br.com.caelum.twittelumappweb.network.TweetApi
import org.koin.dsl.module

val datasources = module {
    single { LoginStorage(context = get()) }
    single { TweetApi(retrofit = get()) }
    single { LoginApi(retrofit = get()) }

}