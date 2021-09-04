package com.example.kmmfoodrecipe01.util

expect class BuildConfig() {
    fun isDebug(): Boolean

    fun isAndroid(): Boolean // true is android client, false if iOS
}