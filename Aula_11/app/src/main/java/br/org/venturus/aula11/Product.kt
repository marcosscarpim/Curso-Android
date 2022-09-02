package br.org.venturus.aula11

import androidx.annotation.DrawableRes

data class Product(@DrawableRes val image: Int, val name: String, val brand: String)
