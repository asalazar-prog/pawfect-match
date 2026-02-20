package com.asalazar.pawfectmatch.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.asalazar.pawfectmatch.R
import com.asalazar.pawfectmatch.ui.icon.bird
import com.asalazar.pawfectmatch.ui.icon.bunny
import com.asalazar.pawfectmatch.ui.icon.cat
import com.asalazar.pawfectmatch.ui.icon.dog

enum class Species(@field:StringRes val labelRes: Int, val icon: ImageVector) {
    DOG(R.string.species_dog, dog),
    CAT(R.string.species_cat, cat),
    BUNNY(R.string.species_bunny, bunny),
    BIRD(R.string.species_bird, bird)
}
