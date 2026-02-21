package com.asalazar.pawfectmatch.model

import androidx.annotation.DrawableRes

data class Pet(
    val id: UInt = 0U,
    val name: String,
    val gender: Gender,
    val ageInMonths: UInt = 0U,
    val nature: List<AnimalNature>,
    @field:DrawableRes val photo: Int,
    val isSterilized: Boolean = false,
    val species: Species,
    val breed: String
)
