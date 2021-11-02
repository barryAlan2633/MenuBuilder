package com.barryalan.menubuilder.presentation.navigation

sealed class Screen(
    val route: String
) {
    object IngredientList : Screen("ingredientList")

    object IngredientDetail : Screen("ingredientDetail")
}