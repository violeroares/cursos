package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.utils.getAllFeaturesOrdered
import com.rockandcode.cursos.utils.getIncludeIcon

@Composable
fun CourseIncludes(course: Course) {
    val allFeatures = course.getAllFeaturesOrdered(expandDocumentTypes = false)

//    fun pluralize(
//        word: String,
//        count: Int,
//    ) = if (count == 1) word else word + "s"

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Este curso incluye:", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))

        allFeatures.forEach { feature ->
            val type = feature.featureType
            // val count = feature.value?.toIntOrNull() ?: 0
//            val text =
//                if (type.showValue && feature.value != null) {
//                    "${feature.value} ${type.unitLabel ?: ""}"
//                } else {
//                    type.name
//                }

            val text =
                if (type.showValue && feature.value != null) {
                    // "${feature.value} ${pluralize(type.unitLabel ?: "", count)}"
                    "${feature.value} ${type.unitLabel}"
                } else {
                    type.name
                }

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 4.dp)) {
                Icon(
                    imageVector = getIncludeIcon(type.iconKey),
                    contentDescription = type.name,
                )
                Spacer(Modifier.width(8.dp))
                Text(text, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

// @Composable
// fun CourseIncludes(course: Course) {
//    val totalSeconds =
//        course.sections.sumOf { section ->
//            section.videos.sumOf { it.durationSeconds }
//        }
//
//    // Agrupar documentos por tipo
//    val documentsByType = course.documents.groupBy { it.documentType.id }
//
//    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
//        Text(
//            "Este curso incluye:",
//            style = MaterialTheme.typography.titleMedium,
//            fontWeight = FontWeight.Bold,
//        )
//        Spacer(Modifier.height(8.dp))
//
//        if (totalSeconds > 0) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(vertical = 4.dp),
//            ) {
//                Icon(
//                    imageVector = Icons.Outlined.PlayCircle,
//                    contentDescription = null,
//                )
//                Spacer(Modifier.width(8.dp))
//                Text(
//                    text = formatDuration(totalSeconds) + " de video bajo demanda",
//                    style = MaterialTheme.typography.bodyMedium,
//                )
//            }
//        }
//
//        documentsByType.forEach { (_, group) ->
//            val type = group.first().documentType
//            val count = group.size
//
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(vertical = 4.dp),
//            ) {
//                Icon(
//                    imageVector = getIncludeIcon(include.type.iconUrl.lowercase()),
//                    contentDescription = include.description,
//                )
//                Spacer(Modifier.width(8.dp))
//                Text(include.description, style = MaterialTheme.typography.bodyMedium)
//            }
//        }
//    }
// }
