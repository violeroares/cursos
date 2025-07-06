package com.rockandcode.cursos.domain.models

data class RangeMedal(
    val id: Int,
    val name: String,
    val number: Int,
    val description: String,
    val benefits: List<String> = emptyList(),
    val icon: String,
    val threshold: Int,
)
