package com.asalazar.pawfectmatch.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Female
import androidx.compose.material.icons.rounded.Male
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.asalazar.pawfectmatch.R

enum class Gender(@field:StringRes val labelRes: Int,val icon: ImageVector,val color: Color) {
    MALE(R.string.gender_male, Icons.Rounded.Male, Color(0xFF62A6FA)),
    FEMALE(R.string.gender_female, Icons.Rounded.Female, Color(0xFFF473B6))
}
