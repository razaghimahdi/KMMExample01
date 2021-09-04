package com.example.kmmfoodrecipe01.presentation.recipe_detail

import com.example.kmmfoodrecipe01.domain.model.GenericMessageInfo
import com.example.kmmfoodrecipe01.domain.model.Recipe
import com.example.kmmfoodrecipe01.domain.util.Queue

data class RecipeDetailState(
    val isLoading: Boolean = false,
    val recipe: Recipe? = null,
    val queue: Queue<GenericMessageInfo> = Queue(mutableListOf()), // messages to be displayed in ui
){
    // Need secondary constructor to initialize with no args in SwiftUI
    constructor(): this(
        isLoading = false,
        recipe = null,
        queue = Queue(mutableListOf()),
    )

}






