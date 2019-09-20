package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.dto.TweetDTO
import br.com.caelum.twittelumappweb.modelo.Tweet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TweetViewModel(private val repository: TweetRepository) : ViewModel() {

    private val tweets = MutableLiveData<List<TweetDTO>>()

    fun salva(tweet: Tweet) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.salva(tweet)
        }
    }

    fun getTweets() = tweets as LiveData<List<TweetDTO>>

    fun buscaTweets() {
        CoroutineScope(Dispatchers.IO).launch {

            val lista: List<TweetDTO> = repository.buscaTweets()

            launch(Dispatchers.Main) {

                tweets.postValue(lista)
            }
        }


    }

    fun filtraTweets(texto: String): List<TweetDTO> {

        tweets.value?.let {
            return@filtraTweets it.filter { tweet -> tweet.mensagem.contains(texto, true) }
        }

        return emptyList()
    }

}