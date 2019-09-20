package br.com.caelum.twittelumappweb.data

import br.com.caelum.twittelumappweb.dto.TweetDTO
import br.com.caelum.twittelumappweb.modelo.Tweet
import br.com.caelum.twittelumappweb.network.TweetApi

class TweetRepository(private val api: TweetApi, private val storage: LoginStorage) {

    suspend fun salva(tweet: Tweet) {

        val tweetDTO = TweetDTO(tweet.mensagem, tweet.foto, tweet.latitude, tweet.longitude, storage.getUsuarioLogado())

        api.cria(tweetDTO)
    }

    suspend fun buscaTweets(): List<TweetDTO> {

        return api.buscaTweets()

    }

}