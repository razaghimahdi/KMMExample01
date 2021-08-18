package com.example.kmmfoodrecipe01.android.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.kmmfoodrecipe01.android.presentation.recipe_detail.RecipeDetailScreen
import com.example.kmmfoodrecipe01.android.presentation.recipe_list.RecipeListScreen

/**
 * navBackStackEntry:
 * Representation of an entry in the back stack of a {@link NavController}. The
 * {@link Lifecycle}, {@link ViewModelStore}, and {@link SavedStateRegistry} provided via
 * this object are valid for the lifetime of this destination on the back stack: when this
 * destination is popped off the back stack, the lifecycle will be destroyed, state
 * will no longer be saved, and ViewModels will be cleared.
 */
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {

        composable(route = Screen.RecipeList.route) { navBackStackEntry ->

            RecipeListScreen(
                onSelectedRecipe = { recipeId ->
                    navController.navigate(Screen.RecipeDetail.route + "/$recipeId")
                }
            )

            /*Column {
                Text(text = "RecipeListScreen")
                Divider()
                Button(onClick = {navController.navigate(Screen.RecipeDetail.route)}){
                    Text(text = "Go RecipeDetail")
                }
            }*/

        }

        /** so adding "/{recipeId}" it means that we have a value which is coming to you*/
        composable(route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ) { navBackStackEntry ->

            RecipeDetailScreen(recipeId = navBackStackEntry.arguments?.getInt("recipeId"))

            /*Column {
                    Text(text = "RecipeDetailScreen")
                }*/
        }


    }
}