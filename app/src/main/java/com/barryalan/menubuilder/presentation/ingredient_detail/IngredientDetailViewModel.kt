package com.barryalan.menubuilder.presentation.ingredient_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class IngredientDetailViewModel
@Inject
constructor(
    private val savedStateHandle: SavedStateHandle
):ViewModel() {
    val ingredientId: MutableState<String?> = mutableStateOf(null)

    init {
        savedStateHandle.get<String>("ingredientId")?.let { ingredientId ->
            this.ingredientId.value = ingredientId
        }
    }
}

//todo build template to build these viewmodels