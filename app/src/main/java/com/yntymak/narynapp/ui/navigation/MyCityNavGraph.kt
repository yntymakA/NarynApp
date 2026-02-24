package com.yntymak.narynapp.ui.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yntymak.narynapp.data.LocalDataProvider
import com.yntymak.narynapp.ui.MyCityViewModel
import com.yntymak.narynapp.ui.screens.CategoryScreen
import com.yntymak.narynapp.ui.screens.DetailScreen
import com.yntymak.narynapp.ui.screens.RecommendationScreen

object MyCityRoutes {
    const val CATEGORY = "category"
    const val RECOMMENDATIONS = "recommendations/{categoryId}"
    const val DETAILS = "details/{placeId}"

    fun recommendations(categoryId: Int) = "recommendations/$categoryId"
    fun details(placeId: Int) = "details/$placeId"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityNavGraph(
    windowWidthSizeClass: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MyCityViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val isExpanded = windowWidthSizeClass == WindowWidthSizeClass.Expanded

    val canNavigateBack = currentRoute != MyCityRoutes.CATEGORY

    val topBarTitle = when (currentRoute) {
        MyCityRoutes.DETAILS -> uiState.selectedPlace?.name ?: "Детали"
        MyCityRoutes.RECOMMENDATIONS -> uiState.selectedCategory?.name ?: "Рекомендации"
        else -> "Мой город — Нарын"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = topBarTitle,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    if (canNavigateBack) {
                        IconButton(onClick = {
                            viewModel.navigateBack()
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Назад"
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MyCityRoutes.CATEGORY,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(MyCityRoutes.CATEGORY) {
                CategoryScreen(
                    categories = viewModel.getCategories(),
                    onCategoryClick = { category ->
                        viewModel.selectCategory(category)
                        navController.navigate(MyCityRoutes.recommendations(category.id))
                    }
                )
            }

            composable(
                route = MyCityRoutes.RECOMMENDATIONS,
                arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
            ) { backStackEntry ->
                val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: return@composable
                val category = LocalDataProvider.getCategoryById(categoryId)
                val places = viewModel.getPlacesForCategory(categoryId)

                if (isExpanded) {
                    // Two-pane layout: list + detail side by side
                    Row(modifier = Modifier.fillMaxWidth()) {
                        RecommendationScreen(
                            categoryName = category?.name ?: "",
                            places = places,
                            onPlaceClick = { place ->
                                viewModel.selectPlace(place)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                        )
                        val selectedPlace = uiState.selectedPlace
                        if (selectedPlace != null && selectedPlace.category.id == categoryId) {
                            DetailScreen(
                                place = selectedPlace,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                            )
                        }
                    }
                } else {
                    RecommendationScreen(
                        categoryName = category?.name ?: "",
                        places = places,
                        onPlaceClick = { place ->
                            viewModel.selectPlace(place)
                            navController.navigate(MyCityRoutes.details(place.id))
                        }
                    )
                }
            }

            composable(
                route = MyCityRoutes.DETAILS,
                arguments = listOf(navArgument("placeId") { type = NavType.IntType })
            ) { backStackEntry ->
                val placeId = backStackEntry.arguments?.getInt("placeId") ?: return@composable
                val place = viewModel.getPlaceById(placeId) ?: return@composable

                DetailScreen(place = place)
            }
        }
    }
}
