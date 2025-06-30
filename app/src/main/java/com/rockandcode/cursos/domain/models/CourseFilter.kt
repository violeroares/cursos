package com.rockandcode.cursos.domain.models

// data class CourseFilter(
//    val categoryId: Int? = null,
//    val minDuration: Int? = null,
//    val maxDuration: Int? = null,
// )

data class CourseFilter(
    val categories: Set<Int> = emptySet(), // ids de categorías seleccionadas
    val orderBy: OrderBy = OrderBy.NONE,
    val minDuration: Int? = null,
    val maxDuration: Int? = null,
    val searchQuery: String = "",
)

enum class OrderBy {
    NONE,
    POPULAR,
    RATED,
    TITLE,
}
