package com.rockandcode.cursos.ui.components

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.rockandcode.cursos.R
import com.rockandcode.cursos.domain.models.Course

@Composable
fun CourseDocuments(course: Course) {
    val context = LocalContext.current
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        Text(
            text = "Materiales del curso",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        course.documents.forEach { doc ->
            val iconRes =
                when (doc.documentType.fileExtension?.lowercase()) {
                    "pdf" -> R.drawable.ic_pdf
                    "doc", "docx" -> R.drawable.ic_pdf
                    "xls", "xlsx" -> R.drawable.ic_pdf
                    "ppt", "pptx" -> R.drawable.ic_pdf
                    else -> R.drawable.ic_pdf
                }
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW, doc.url.toUri())
                            context.startActivity(intent)
                        }.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Icon(Icons.Default.Description, contentDescription = null)
                Icon(painterResource(iconRes), contentDescription = doc.documentType.name)
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(doc.title, style = MaterialTheme.typography.bodyLarge)
                    // Text(doc.description, style = MaterialTheme.typography.bodySmall)
                }
                Icon(
                    imageVector = Icons.Default.Download, // o Icons.Outlined.Download
                    contentDescription = "Descargar",
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}
