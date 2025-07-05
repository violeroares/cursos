package com.rockandcode.cursos.domain.models

data class FeatureType(
    val id: Int,
    val name: String,
    val iconKey: String,
    val showValue: Boolean,
    val unitLabel: String?,
    val displayOrder: Int,
)
