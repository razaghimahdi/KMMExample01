package com.example.kmmfoodrecipe01.presentation.recipe_detail

sealed class RecipeDetailEvents {

    data class GetRecipe(val recipeId: Int): RecipeDetailEvents()

    object OnRemoveHeadMessageFromQueue: RecipeDetailEvents()
}