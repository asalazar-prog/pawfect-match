package com.asalazar.pawfectmatch.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.asalazar.pawfectmatch.R

enum class AnimalNature(
    @StringRes val labelRes: Int,
    val containerColor: Color,
    val contentColor: Color
) {
    PLAYFUL(R.string.nature_playful, Color(0xFFFFECB3), Color(0xFFFFA000)),
    ACTIVE(R.string.nature_active, Color(0xFFE1F5FE), Color(0xFF0288D1)),
    GUARD(R.string.nature_guard, Color(0xFFFFEBEE), Color(0xFFD32F2F)),
    LOYAL(R.string.nature_loyal, Color(0xFFEDE7F6), Color(0xFF512DA8)),
    SMART(R.string.nature_smart, Color(0xFFE8F5E9), Color(0xFF388E3C)),
    QUIET(R.string.nature_quiet, Color(0xFFF5F5F5), Color(0xFF616161)),
    FRIENDLY(R.string.nature_friendly, Color(0xFFFFF3E0), Color(0xFFE65100)),
    AFFECTIONATE(R.string.nature_affectionate, Color(0xFFFCE4EC), Color(0xFFC2185B)),
    INDEPENDENT(R.string.nature_independent, Color(0xFFE0F2F1), Color(0xFF00796B)),
    PROTECTIVE(R.string.nature_protective, Color(0xFFEFEBE9), Color(0xFF5D4037)),
    CALM(R.string.nature_calm, Color(0xFFE0F7FA), Color(0xFF0097A7)),
    SOCIAL(R.string.nature_social, Color(0xFFF1F8E9), Color(0xFF689F38)),
    SHY(R.string.nature_shy, Color(0xFFECEFF1), Color(0xFF455A64)),
    ADVENTUROUS(R.string.nature_adventurous, Color(0xFFFFFDE7), Color(0xFFFBC02D))
}
