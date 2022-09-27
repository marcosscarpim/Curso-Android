package br.org.venturus.internetrequest.remote.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal class JokeService {

    val jokeApi: JokeApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        jokeApi = retrofit.create(JokeApi::class.java)
    }

    private companion object {
        private const val BASE_URL = "https://official-joke-api.appspot.com/"
    }
}