package br.org.venturus.internetrequest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.org.venturus.internetrequest.remote.api.JokeService
import br.org.venturus.internetrequest.remote.model.JokeResponse
import kotlinx.coroutines.launch

internal class JokeViewModel : ViewModel() {

    private val jokeService = JokeService()

    private val _jokeData: MutableLiveData<JokeResponse> = MutableLiveData()
    val jokeData: LiveData<JokeResponse> = _jokeData

    fun loadJoke() = viewModelScope.launch {
        val joke = jokeService.jokeApi.getRandomJoke()
        _jokeData.value = joke
    }
}