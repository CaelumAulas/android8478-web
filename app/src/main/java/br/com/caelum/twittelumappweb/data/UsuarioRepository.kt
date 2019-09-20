package br.com.caelum.twittelumappweb.data

import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.network.LoginApi

class UsuarioRepository(private val api: LoginApi, private val storage: LoginStorage) {

    suspend fun cria(usuario: Usuario): Usuario {
        val logado = api.cria(usuario)

        storage.salva(logado)

        return logado
    }
    suspend fun loga(usuario: Usuario): Usuario {
        val logado = api.loga(usuario)

        storage.salva(logado)

        return logado

    }
}
