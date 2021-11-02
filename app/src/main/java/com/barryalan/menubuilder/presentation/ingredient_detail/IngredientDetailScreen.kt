package com.barryalan.menubuilder.presentation.ingredient_detail


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.barryalan.menubuilder.domain.model.Ingredient

@Composable
fun IngredientDetailScreen(
    ingredient: Ingredient?,
) {
    if(ingredient == null){
        Text("Unable to get the details of this ingredient")
    }else{
        Text("IngredientDetailScreen ${ingredient.name}")
    }
}