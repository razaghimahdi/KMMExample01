package com.example.kmmfoodrecipe01.android.presentation.recipe_detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecipeDetailScreen(
    recipeId:Int?
) {
    if (recipeId==null){
        Text(text = "ERROR")
    }else{

        Text(modifier = Modifier.padding(16.dp),
            text = "RecipeDetailScreen = ${recipeId}")
    }
}