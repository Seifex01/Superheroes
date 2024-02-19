package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superheroes.R

data class Hero(
    @StringRes val nombre: Int,
    @StringRes val descripcion: Int,
    @DrawableRes val imageResourceId: Int
)



