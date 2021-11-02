package com.barryalan.menubuilder.di

import com.barryalan.menubuilder.interactors.ingredient_detail.GetIngredient
import com.barryalan.menubuilder.interactors.ingredient_list.SearchIngredients
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun providesSearchIngredients(

    ):SearchIngredients{
        return SearchIngredients()
    }

    @Singleton
    @Provides
    fun providesGetIngredient(

    ):GetIngredient{
        return GetIngredient()
    }
}