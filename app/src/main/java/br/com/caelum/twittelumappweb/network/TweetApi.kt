package br.com.caelum.twittelumappweb.network

import br.com.caelum.twittelumappweb.dto.TweetDTO
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class TweetApi(retrofit: Retrofit) {

    private val service by lazy {
        retrofit.create(TweetService::class.java)
    }

    suspend fun cria(tweet: TweetDTO) =
            service.cria(tweet)

    suspend fun buscaTweets() = service.busca()

    interface TweetService {

        @POST("tweet")
        suspend fun cria(@Body tweet: TweetDTO): TweetDTO

        @GET("tweet")
        suspend fun busca(): List<TweetDTO>

    }
}