package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.RangeMedal

data class RangeMedalDto(
    val id: Int,
    val name: String,
    val number: Int,
    val description: String,
    val benefits: List<String> = emptyList(),
    val icon: String,
    val threshold: Int,
) {
    fun toDomain() = RangeMedal(id, name, number, description, benefits, icon, threshold)
}
