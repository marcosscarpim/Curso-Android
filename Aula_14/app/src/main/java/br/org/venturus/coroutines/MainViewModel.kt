package br.org.venturus.coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class MainViewModel : ViewModel() {

    private val _state: MutableLiveData<MainViewState> = MutableLiveData(MainViewState.Idle)
    val state: LiveData<MainViewState> = _state

    fun runHeavyWork() {
        viewModelScope.launch {
            _state.value = MainViewState.Loading
            prepareExecution()
            _state.value = MainViewState.Executing
            heavyWork()
            _state.value = MainViewState.Success
        }
    }

    private suspend fun prepareExecution() =
        withContext(Dispatchers.Default) {
            println("Preparing execution...")
            delay(2000L)
        }

    private suspend fun heavyWork() =
        withContext(Dispatchers.IO) {
            println("Heavy work running...")
            delay(4000L)
        }
}