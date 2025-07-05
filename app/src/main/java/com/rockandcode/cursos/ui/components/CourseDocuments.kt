package com.rockandcode.cursos.ui.components

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.rockandcode.cursos.domain.models.Course

@Composable
fun CourseDocuments(course: Course) {
    val isDarkTheme = isSystemInDarkTheme()
    val context = LocalContext.current
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        Text(
            text = "Materiales del curso",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp),
        )
        course.documents.forEach { doc ->
//            val iconRes =
//                when (doc.documentType.fileExtension?.lowercase()) {
//                    "pdf" -> R.drawable.ic_pdf
//                    "doc", "docx" -> R.drawable.ic_pdf
//                    "xls", "xlsx" -> R.drawable.ic_pdf
//                    "ppt", "pptx" -> R.drawable.ic_pdf
//                    else -> R.drawable.ic_pdf
//                }
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW, doc.url.toUri())
                            context.startActivity(intent)
                        }.padding(vertical = 6.dp, horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Icon(Icons.Default.Description, contentDescription = null)
                // Icon(painterResource(iconRes), contentDescription = doc.documentType.name)
                Icon(
                    imageVector = Icons.Outlined.AttachFile,
                    contentDescription = doc.documentType.name,
                    tint = if (!isDarkTheme) Color(0xFF2B1BBA) else MaterialTheme.colorScheme.onSecondaryContainer,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(doc.title, style = MaterialTheme.typography.bodyLarge)
                    // Text(doc.description, style = MaterialTheme.typography.bodySmall)
                }
                Box(
                    modifier =
                        Modifier
                            .size(32.dp)
                            .background(
                                if (!isDarkTheme) Color(0xFFD5D1F3) else MaterialTheme.colorScheme.secondaryContainer,
                                shape = CircleShape,
                            ),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FileDownload,
                        contentDescription = "Descargar",
                        tint = if (!isDarkTheme) Color(0xFF2B1BBA) else MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier.size(20.dp),
                        // tint = MaterialTheme.colorScheme.primary,
                    )
                }
            }
        }
    }
}
