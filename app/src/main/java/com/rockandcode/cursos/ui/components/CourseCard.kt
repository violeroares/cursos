package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.Course

@Composable
fun CourseCard(
    course: Course,
    onClick: () -> Unit = {},
) {
    Card(
        modifier =
            Modifier
                .width(240.dp)
                .padding(end = 12.dp)
                .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = course.thumbnailUrl,
                contentDescription = course.title,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(course.title, maxLines = 2)
            Text("⭐ ${course.rating}", style = MaterialTheme.typography.labelSmall)
            Text("${course.price} USD", fontWeight = FontWeight.Bold)
        }
    }
}
