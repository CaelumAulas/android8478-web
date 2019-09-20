package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.SplashRepository

class MainViewModel(private val repository: SplashRepository) : ViewModel() {
    fun desloga() = repository.desloga()
}
