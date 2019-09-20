package br.com.caelum.twittelumappweb.di

import br.com.caelum.twittelumappweb.data.SplashRepository
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import org.koin.dsl.module

val repositories = module {

    single { SplashRepository(storage = get()) }
    single { TweetRepository(storage = get(), api = get()) }
    single { UsuarioRepository(api = get(), storage = get()) }

}