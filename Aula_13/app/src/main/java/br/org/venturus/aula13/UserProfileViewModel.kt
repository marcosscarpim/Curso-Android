package br.org.venturus.aula13

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

internal class UserProfileViewModel : ViewModel() {

    private val _profileInfo: MutableLiveData<UserInfo> = MutableLiveData()
    val profileInfo: LiveData<UserInfo> = _profileInfo

    fun loadProfile() {
        _profileInfo.value = UserInfo(
            profileImage = R.mipmap.ic_launcher,
            headerImage = R.drawable.ic_launcher_background,
            name = R.string.user_name,
            description = R.string.user_description,
            bio = R.string.user_bio
        )
    }
}