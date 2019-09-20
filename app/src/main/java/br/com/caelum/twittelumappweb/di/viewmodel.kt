package br.com.caelum.twittelumappweb.di

import br.com.caelum.twittelumappweb.viewmodel.MainViewModel
import br.com.caelum.twittelumappweb.viewmodel.SplashViewModel
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.UsuarioViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModels = module {

    viewModel { SplashViewModel(repository = get()) }
    viewModel { TweetViewModel(repository = get()) }
    viewModel { UsuarioViewModel(repository = get()) }
    viewModel { MainViewModel(repository = get()) }
}