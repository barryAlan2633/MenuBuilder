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
import com.barryalan.menubuilder.presentation.ingredient_list.IngredientListViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.IngredientList.route) {

        composable(route = Screen.IngredientList.route) { navBackStackEntry ->
            IngredientListScreen(
                onSelectedIngredient = {ingredientId->
                    navController.navigate(Screen.IngredientDetail.route + "/$ingredientId")
                }
            )
        }

        composable(
            route = Screen.IngredientDetail.route + "/{ingredientId}",
            arguments = listOf(navArgument("ingredientId"){
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val viewModel: IngredientDetailViewModel = hiltViewModel()

            IngredientDetailScreen(ingredientId = viewModel.ingredientId.value)
        }
    }
}
