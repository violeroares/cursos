package com.rockandcode.cursos.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material.icons.outlined.Verified
import androidx.compose.ui.graphics.vector.ImageVector
import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.domain.models.CourseFeatureItem
import com.rockandcode.cursos.domain.models.FeatureType

// ---------------------------------------------------
// Extension Function en Course
// ---------------------------------------------------
fun Course.getAllFeaturesOrdered(expandDocumentTypes: Boolean = true): List<CourseFeatureItem> {
    // 1. Features dinámicas

    // 1.a Video bajo demanda
    val totalSeconds = sections.sumOf { it.videos.sumOf { it.durationSeconds } }
    val videoFeature =
        totalSeconds.takeIf { it > 0 }?.let {
            CourseFeatureItem(
                featureType =
                    FeatureType(
                        id = -1,
                        name = "Video bajo demanda",
                        iconKey = "video",
                        showValue = true,
                        unitLabel = "de video bajo demanda",
                        displayOrder = 1, // siempre primero
                    ),
                // value = (it / 60).toString(), // minutos totales
                value = formatDuration(it).toString(),
            )
        }

    // 1.b Documentos agrupados por tipo
    val documentFeatures =
        if (documents.isNotEmpty()) {
            if (expandDocumentTypes) {
                documents
                    .groupBy { it.documentType.id }
                    .toList()
                    .mapIndexed { index, (_, group) ->
                        val docType = group.first().documentType
                        val label = docType.name.lowercase() // ej: clase, ejercicio

                        CourseFeatureItem(
                            featureType =
                                FeatureType(
                                    id = docType.id,
                                    name = docType.name,
                                    iconKey = label,
                                    showValue = true,
                                    unitLabel = label,
                                    displayOrder = 2 + index, // justo después de video
                                ),
                            value = group.size.toString(),
                        )
                    }
            } else {
                listOf(
                    CourseFeatureItem(
                        featureType =
                            FeatureType(
                                id = -2,
                                name = "Documento",
                                iconKey = "document",
                                showValue = true,
                                unitLabel = if (documents.size > 1) "recursos descargables" else "recurso descargable",
                                displayOrder = 2,
                            ),
                        value = documents.size.toString(),
                    ),
                )
            }
        } else {
            emptyList()
        }

    // 2. Combinar con las que vienen del backend
    val combined =
        listOfNotNull(videoFeature) +
            documentFeatures +
            features // backend features ya tienen displayOrder: 5,6,...

    // 3. Ordenar TTODO por displayOrder
    return combined
        .sortedBy { it.featureType.displayOrder }
}

// fun Course.getDynamicFeatures(): List<CourseFeatureItem> {
//    val totalSeconds = sections.sumOf { section -> section.videos.sumOf { it.durationSeconds } }
//
//    val videoFeature =
//        if (totalSeconds > 0) {
//            CourseFeatureItem(
//                featureType =
//                    FeatureType(
//                        id = -1,
//                        name = "Video bajo demanda",
//                        iconKey = "video",
//                        showValue = true,
//                        unitLabel = "minutos",
//                        displayOrder = 0,
//                    ),
//                value = (totalSeconds / 60).toString(),
//            )
//        } else {
//            null
//        }
//
//    val documentFeatures =
//        documents
//            .groupBy { it.documentType.id }
//            .map { (_, group) ->
//                val docType = group.first().documentType
//                CourseFeatureItem(
//                    featureType =
//                        FeatureType(
//                            id = docType.id,
//                            name = docType.name,
//                            iconKey = docType.name.lowercase(),
//                            showValue = true,
//                            unitLabel = docType.name.lowercase(),
//                            displayOrder = 1000,
//                        ),
//                    value = group.size.toString(),
//                )
//            }
//
//    return listOfNotNull(videoFeature) + documentFeatures
//    // return documentFeatures
// }

fun getIncludeIcon(key: String): ImageVector =
    when (key.lowercase()) {
        "video" -> Icons.Outlined.PlayCircle
        "certificate" -> Icons.Outlined.Verified
        "access" -> Icons.Outlined.AccessTime
        "ejercicio" -> Icons.Outlined.Description
        "document" -> Icons.Outlined.Description
        "clase" -> Icons.AutoMirrored.Outlined.MenuBook
        else -> Icons.Outlined.Info
    }

fun formatDuration(totalSeconds: Int): String {
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    return when {
        hours > 0 && minutes > 0 -> "${hours}h ${minutes}m"
        hours > 0 -> "${hours}h"
        else -> "${minutes}m"
    }
}
