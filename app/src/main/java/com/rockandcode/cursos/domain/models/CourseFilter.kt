package com.rockandcode.cursos.domain.models

data class CourseFilter(
    val categories: Set<Int> = emptySet(), // ids de categorías seleccionadas
    val orderBy: OrderBy = OrderBy.NONE,
    val minDuration: Int? = null,
    val maxDuration: Int? = null,
    val searchQuery: String = "",
    val showFree: Boolean = true,
    val showPaid: Boolean = true,
    val minPrice: Int? = null,
    val maxPrice: Int? = null,
)

enum class OrderBy(
    val label: String,
) {
    NONE("Ninguno"),
    POPULAR("Más comprados"),
    RATED("Mejor calificación"),
    TITLE("Titulo"),
    PRICE_ASC("Menor precio"),
    PRICE_DESC("Mayor precio"),
}
