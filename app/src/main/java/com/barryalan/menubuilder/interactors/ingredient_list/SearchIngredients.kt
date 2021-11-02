package com.barryalan.menubuilder.interactors.ingredient_list

import com.barryalan.menubuilder.domain.model.Ingredient
import com.barryalan.menubuilder.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class SearchIngredients(

) {

    fun execute(
        query: String
    ): Flow<DataState<List<Ingredient>>> = flow {
        emit(DataState.loading())

        try {
            val ingredients = listOf(
                Ingredient(id = "a", name = "salt"),
                Ingredient(id = "b", name = "sugar"),
                Ingredient(id = "c", name = "cream")
            )

            emit(DataState.data(message = null, data = ingredients))
        } catch (e: Exception) {
            emit(DataState.error<List<Ingredient>>(message = e.message ?: "Unknown Error"))
        }
    }
}