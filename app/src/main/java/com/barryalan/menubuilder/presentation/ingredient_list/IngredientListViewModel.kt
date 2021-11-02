package com.barryalan.menubuilder.presentation.ingredient_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IngredientListViewModel

@Inject
constructor(
    private val savedStateHandle: SavedStateHandle
):ViewModel(){
}