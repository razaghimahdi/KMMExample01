package com.example.kmmfoodrecipe01.android.presentation.recipe_detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmmfoodrecipe01.android.presentation.components.RECIPE_IMAGE_HEIGHT
import com.example.kmmfoodrecipe01.android.presentation.components.RecipeImage
import com.example.kmmfoodrecipe01.android.presentation.recipe_detail.components.LoadingRecipeShimmer
import com.example.kmmfoodrecipe01.android.presentation.recipe_detail.components.RecipeView
import com.example.kmmfoodrecipe01.android.presentation.recipe_list.component.RecipeCard
import com.example.kmmfoodrecipe01.android.presentation.theme.AppTheme
import com.example.kmmfoodrecipe01.domain.model.Recipe
import com.example.kmmfoodrecipe01.presentation.recipe_detail.RecipeDetailEvents
import com.example.kmmfoodrecipe01.presentation.recipe_detail.RecipeDetailState
import kotlinx.coroutines.ExperimentalCoroutinesApi




@ExperimentalStdlibApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@Composable
fun RecipeDetailScreen(
    state: RecipeDetailState,
    onTriggerEvent: (RecipeDetailEvents) -> Unit,
){
    AppTheme(
        displayProgressBar = state.isLoading,
        dialogQueue = state.queue,
        onRemoveHeadMessageFromQueue = {
            onTriggerEvent(RecipeDetailEvents.OnRemoveHeadMessageFromQueue)
        }
    ){
        if(state.recipe == null && state.isLoading){
            LoadingRecipeShimmer(imageHeight = RECIPE_IMAGE_HEIGHT.dp)
        }
        else if(state.recipe == null){
            Text(
                modifier = Modifier.padding(16.dp),
                text = "We were unable to retrieve the details for this recipe.\nTry resetting the app.",
                style = MaterialTheme.typography.body1
            )
        }
        else{
            RecipeView(recipe = state.recipe!!)
        }
    }
}
