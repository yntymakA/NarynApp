package com.yntymak.narynapp.ui

import androidx.lifecycle.ViewModel
import com.yntymak.narynapp.data.Category
import com.yntymak.narynapp.data.LocalDataProvider
import com.yntymak.narynapp.data.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun selectCategory(category: Category) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    fun selectPlace(place: Place) {
        _uiState.update { it.copy(selectedPlace = place) }
    }

    fun navigateBack() {
        _uiState.update { currentState ->
            when {
                currentState.selectedPlace != null -> currentState.copy(selectedPlace = null)
                currentState.selectedCategory != null -> currentState.copy(selectedCategory = null)
                else -> currentState
            }
        }
    }

    fun getCategories() = LocalDataProvider.categories

    fun getPlacesForCategory(categoryId: Int) = LocalDataProvider.getPlacesByCategory(categoryId)

    fun getPlaceById(placeId: Int) = LocalDataProvider.getPlaceById(placeId)
}
