package com.barryalan.menubuilder.interactors.ingredient_detail

import com.barryalan.menubuilder.domain.model.Ingredient
import com.barryalan.menubuilder.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetIngredient(

) {

    fun execute(
        ingredientId: String,
    ): Flow<DataState<Ingredient>> = flow {
        emit(DataState.loading())
        try {
            val ingredient = Ingredient(id = "SSS", name = "Chicken")
            emit(DataState.data(message = null, data = ingredient))
        } catch (e: Exception) {
            emit(DataState.error<Ingredient>(message = e.message ?: "Unknown Error"))
        }
    }
}