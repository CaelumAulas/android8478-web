package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import br.com.caelum.twittelumappweb.modelo.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel(private val repository: UsuarioRepository) : ViewModel() {

    private val usuarioLiveData = MutableLiveData<Usuario>()
    private val errorLiveData = MutableLiveData<Exception>()


    fun getUsuario() = usuarioLiveData as LiveData<Usuario>
    fun getError() = errorLiveData as LiveData<Exception>

    fun criar(usuario: Usuario) {
        CoroutineScope(context = Dispatchers.IO).launch {
            try {
                val novoUsuario = repository.cria(usuario)
                launch(context = Dispatchers.Main) {
                    usuarioLiveData.postValue(novoUsuario)
                }
            } catch (error: Exception) {
                launch(context = Dispatchers.Main) {
                    errorLiveData.postValue(error)
                }
            }
        }
    }

    fun autenticar(usuario: Usuario) {
        CoroutineScope(context = Dispatchers.IO).launch {
            try {
                val novoUsuario = repository.loga(usuario)
                launch(context = Dispatchers.Main) {
                    usuarioLiveData.postValue(novoUsuario)
                }
            } catch (error: Exception) {
                launch(context = Dispatchers.Main) {
                    errorLiveData.postValue(error)
                }
            }
        }
    }
}
