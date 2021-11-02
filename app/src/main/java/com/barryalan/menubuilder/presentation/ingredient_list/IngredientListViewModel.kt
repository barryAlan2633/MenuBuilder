package com.barryalan.menubuilder.presentation.ingredient_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barryalan.menubuilder.interactors.ingredient_list.SearchIngredients
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class IngredientListViewModel
@Inject
constructor(
    private val savedStateHandle: SavedStateHandle,
    private val searchIngredients: SearchIngredients
) : ViewModel() {

    init{
        loadIngredients()
    }
    private fun loadIngredients() {
        searchIngredients.execute(
            query = ""
        ).onEach { dataState ->
            println("IngredientListVM:${dataState.isLoading}")

            dataState.data?.let { ingredients ->
                println("IngredientListVM:$ingredients")
            }

            dataState.message?.let { message ->
                println("IngredientListVM:$message")
            }

        }.launchIn(viewModelScope)
    }
}