package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.Benefit

data class BenefitDto(
    val id: Int,
    val description: String,
    val discountPercent: Double,
) {
    fun toDomain() =
        Benefit(
            id,
            description,
            discountPercent,
        )
}
