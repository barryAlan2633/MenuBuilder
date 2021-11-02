package com.barryalan.menubuilder.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.barryalan.menubuilder.presentation.ingredient_detail.IngredientDetailScreen
import com.barryalan.menubuilder.presentation.ingredient_detail.IngredientDetailViewModel
import com.barryalan.menubuilder.presentation.ingredient_list.IngredientListScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.barryalan.menubuilder.presentation.ingredient_list.IngredientListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.IngredientList.route) {

        composable(route = Screen.IngredientList.route) { navBackStackEntry ->
            val viewModel: IngredientListViewModel = hiltViewModel()

            IngredientListScreen(
                onSelectedIngredient = { ingredientId ->

                    navController.navigate(Screen.IngredientDetail.route + "/$ingredientId")
                }
            )
        }

        composable(
            route = Screen.IngredientDetail.route + "/{ingredientId}",
            arguments = listOf(navArgument("ingredientId") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val viewModel: IngredientDetailViewModel = hiltViewModel()

            IngredientDetailScreen(ingredient = viewModel.ingredient.value)
        }
    }
}
