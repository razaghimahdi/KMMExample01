package com.example.kmmfoodrecipe01.domain.model

sealed class UIComponentType{

    object Dialog: UIComponentType()

    object None: UIComponentType()
}