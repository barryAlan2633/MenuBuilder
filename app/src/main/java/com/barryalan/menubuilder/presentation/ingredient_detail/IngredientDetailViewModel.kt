package com.barryalan.menubuilder.presentation.ingredient_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.barryalan.menubuilder.domain.model.Ingredient
import com.barryalan.menubuilder.interactors.ingredient_detail.GetIngredient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class IngredientDetailViewModel
@Inject
constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getIngredient: GetIngredient
) : ViewModel() {
    val ingredient: MutableState<Ingredient?> = mutableStateOf(null)

    init {
        savedStateHandle.get<String>("ingredientId")?.let { ingredientId ->
            viewModelScope.launch {
                getIngredient(ingredientId = ingredientId)
            }
        }
    }

    private fun getIngredient(ingredientId: String) {
        getIngredient.execute(ingredientId = ingredientId).onEach { dataState ->
            println("IngredientDetailVM:${dataState.isLoading}")

            dataState.data?.let { ingredient ->
                println("IngredientDetailVM:$ingredient")
                this.ingredient.value = ingredient
            }

            dataState.message?.let { message ->
                println("IngredientDetailVM:$message")
            }

        }.launchIn(viewModelScope)
    }
}

//todo build template to build these viewmodels