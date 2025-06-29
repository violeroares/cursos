package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.RangeMedal

data class RangeMedalDto(
    val id: Int,
    val name: String,
    val description: String,
    val icon: String,
    val threshold: Int,
) {
    fun toDomain() = RangeMedal(id, name, description, icon, threshold)
}
