package com.example.kmmfoodrecipe01.datasource.network

import com.example.kmmfoodrecipe01.domain.model.Recipe

interface RecipeService {

    suspend fun search(
        page: Int,
        query: String,
    ): List<Recipe>

    suspend fun get(
        id: Int
    ): Recipe
}