package br.org.venturus.aula13

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

internal data class UserInfo(
    @DrawableRes val profileImage: Int,
    @DrawableRes val headerImage: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val bio: Int
)