package com.rockandcode.cursos.data.models

data class FeatureTypeDto(
    val id: Int,
    val name: String,
    val iconKey: String,
    val showValue: Boolean,
    val unitLabel: String?,
    val displayOrder: Int,
)
