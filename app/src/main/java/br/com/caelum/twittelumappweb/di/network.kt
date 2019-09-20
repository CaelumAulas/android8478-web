package br.com.caelum.twittelumappweb.di

import br.com.caelum.twittelumappweb.network.InicializadorDoRetrofit
import org.koin.dsl.module

val network = module {
    single { InicializadorDoRetrofit.cria() }
}