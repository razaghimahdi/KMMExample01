package com.example.kmmfoodrecipe01.interactors.recipe_detail

import com.example.kmmfoodrecipe01.datasource.cache.RecipeCache
import com.example.kmmfoodrecipe01.datasource.network.RecipeService
import com.example.kmmfoodrecipe01.domain.model.GenericMessageInfo
import com.example.kmmfoodrecipe01.domain.model.Recipe
import com.example.kmmfoodrecipe01.domain.model.UIComponentType
import com.example.kmmfoodrecipe01.domain.util.CommonFlow
import com.example.kmmfoodrecipe01.domain.util.DataState
import com.example.kmmfoodrecipe01.domain.util.asCommonFlow
import com.example.kmmfoodrecipe01.util.BuildConfig
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipe (
    private val recipeCache: RecipeCache,
){

    fun execute(
        recipeId: Int,
    ): CommonFlow<DataState<Recipe>> = flow {
        try {
            emit(DataState.loading())

            // just to show loading, cache is fast
            // Note: iOS loads the DetailView ahead of time so delaying here for iOS is pointless
            if(BuildConfig().isDebug() && BuildConfig().isAndroid()){
                delay(500)
            }

            // Force error for testing
            if(recipeId == 1){
                throw Exception("Invalid Recipe Id")
            }

            val recipe =  recipeCache.get(recipeId)

            emit(DataState.data(message = null, data = recipe))

        }catch (e: Exception){
            emit(DataState.error<Recipe>(
                message = GenericMessageInfo.Builder()
                    .id("GetRecipe.Error")
                    .title("Error")
                    .uiComponentType(UIComponentType.Dialog)
                    .description(e.message?: "Unknown Error")
            ))
        }
    }.asCommonFlow()


}