package com.asalazar.pawfectmatch.model

import androidx.annotation.StringRes
import com.asalazar.pawfectmatch.R

enum class AnimalNature(@field:StringRes val labelRes: Int) {
    PLAYFUL(R.string.nature_playful),
    ACTIVE(R.string.nature_active),
    GUARD(R.string.nature_guard),
    LOYAL(R.string.nature_loyal),
    SMART(R.string.nature_smart),
    QUIET(R.string.nature_quiet),
    FRIENDLY(R.string.nature_friendly),
    AFFECTIONATE(R.string.nature_affectionate),
    INDEPENDENT(R.string.nature_independent),
    PROTECTIVE(R.string.nature_protective),
    CALM(R.string.nature_calm),
    SOCIAL(R.string.nature_social),
    SHY(R.string.nature_shy),
    ADVENTUROUS(R.string.nature_adventurous)
}
