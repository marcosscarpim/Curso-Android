package br.org.venturus.coroutines.userprofile

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

internal class UserProfileRepository {

    suspend fun fetchUserData(): String {
        return withContext(Dispatchers.IO) {
            delay(7000L)
            "José da Silva"
        }
    }
}