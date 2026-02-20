package com.asalazar.pawfectmatch.model

import androidx.annotation.StringRes
import com.asalazar.pawfectmatch.R

enum class Gender(@field:StringRes val labelRes: Int) {
    MALE(R.string.gender_male),
    FEMALE(R.string.gender_female)
}
