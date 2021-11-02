package com.barryalan.menubuilder.presentation.ingredient_detail


import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun IngredientDetailScreen(
    ingredientId:String?,
) {
    if(ingredientId == null){
        Text("ERROR")
    }else{
        Text("IngredientDetailScreen $ingredientId")
    }
}