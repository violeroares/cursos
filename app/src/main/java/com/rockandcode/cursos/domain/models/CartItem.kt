package com.rockandcode.cursos.domain.models

data class CartItem(
    val courseId: Int,
    val title: String,
    val author: String,
    val imageUrl: String,
    val price: Double,
)
