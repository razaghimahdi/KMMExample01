package com.example.kmmfoodrecipe01.datasource.cache

import android.content.Context
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory {
    actual fun createDriver():SqlDriver{
        return NativeSqliteDriver(RecipeDatabase.Schema,"recipes.db")
    }
}