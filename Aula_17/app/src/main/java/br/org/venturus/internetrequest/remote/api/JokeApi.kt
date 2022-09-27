package br.org.venturus.internetrequest.remote.api

import br.org.venturus.internetrequest.remote.model.JokeResponse
import retrofit2.http.GET

internal interface JokeApi {

    @GET("/random_joke")
    suspend fun getRandomJoke(): JokeResponse
}
