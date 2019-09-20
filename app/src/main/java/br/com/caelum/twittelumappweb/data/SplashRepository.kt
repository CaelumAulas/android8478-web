package br.com.caelum.twittelumappweb.data

class SplashRepository(private val storage: LoginStorage) {

    fun estaLogado() = storage.getUsuarioLogado().id != 0

    fun desloga() = storage.desloga()

}
