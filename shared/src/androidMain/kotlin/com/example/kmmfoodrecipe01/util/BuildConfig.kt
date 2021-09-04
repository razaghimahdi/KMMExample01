package com.example.kmmfoodrecipe01.util

import com.example.kmmfoodrecipe01.BuildConfig

actual class BuildConfig {
    actual fun isDebug() = BuildConfig.DEBUG
    actual fun isAndroid() = true
}