package com.example.kmmfoodrecipe01.android.di

import  com.example.kmmfoodrecipe01.datasource.network.RecipeService
import  com.example.kmmfoodrecipe01.datasource.network.RecipeServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient{
        return com.example.kmmfoodrecipe01.datasource.network.KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideRecipeService(
        httpClient: HttpClient,
    ): RecipeService {
        return RecipeServiceImpl(
            httpClient = httpClient,
            baseUrl = RecipeServiceImpl.BASE_URL,
        )
    }
}
