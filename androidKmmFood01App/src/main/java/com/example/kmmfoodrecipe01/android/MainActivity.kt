package com.example.kmmfoodrecipe01.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.kmmfoodrecipe01.android.presentation.navigation.Navigation
import com.example.kmmfoodrecipe01.datasource.network.KtorClientFactory
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlin.collections.get

const val TOKEN = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
const val BASE_URL = "https://food2fork.ca/api/recipe"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    @ExperimentalStdlibApi
    @ExperimentalMaterialApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val ktorClient = KtorClientFactory().build()
        CoroutineScope(IO).launch {
            val recipeId = 1551
            val recipe = ktorClient.get<String> {
                url("$BASE_URL/get?id=$recipeId")
                header("Authorization", TOKEN)
            }
            println("KtorTest: ${recipe}")
        }


        setContent{
            Navigation()
        }


    }
}
