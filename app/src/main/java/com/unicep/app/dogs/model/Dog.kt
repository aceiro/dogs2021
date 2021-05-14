package com.unicep.app.dogs.model

import androidx.annotation.DrawableRes

data class Dog(val name: String, val details: String, @DrawableRes val imageResId: Int)
