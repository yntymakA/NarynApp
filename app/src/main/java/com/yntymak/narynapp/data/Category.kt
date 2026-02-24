package com.yntymak.narynapp.data

import androidx.annotation.DrawableRes

data class Category(
    val id: Int,
    val name: String,
    val description: String,
    @param:DrawableRes @get:DrawableRes val iconRes: Int
)
