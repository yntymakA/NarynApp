package com.yntymak.narynapp.ui

import com.yntymak.narynapp.data.Category
import com.yntymak.narynapp.data.Place

data class MyCityUiState(
    val selectedCategory: Category? = null,
    val selectedPlace: Place? = null
)
