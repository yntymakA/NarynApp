package com.yntymak.narynapp.data

import androidx.annotation.DrawableRes

data class Place(
    val id: Int,
    val name: String,
    val description: String,
    @param:DrawableRes @get:DrawableRes val imageRes: Int,
    val category: Category
)
