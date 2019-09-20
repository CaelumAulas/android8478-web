package br.com.caelum.twittelumappweb.dto

import br.com.caelum.twittelumappweb.modelo.Usuario
import com.google.gson.annotations.SerializedName

data class TweetDTO(
        val mensagem: String,
        val foto: String?,
        val latitude: Double,
        val longitude: Double,
@SerializedName("dono")
        val usuario: Usuario
)