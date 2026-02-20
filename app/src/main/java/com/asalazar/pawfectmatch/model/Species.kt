package com.asalazar.pawfectmatch.model

import androidx.annotation.StringRes
import com.asalazar.pawfectmatch.R

enum class Species(@field:StringRes val labelRes: Int) {
    DOG(R.string.species_dog),
    CAT(R.string.species_cat),
    BUNNY(R.string.species_bunny),
    BIRD(R.string.species_bird)
}
