package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rockandcode.cursos.domain.models.Comment

@Composable
fun CourseCommentsSection(comments: List<Comment>) {
    if (comments.isEmpty()) return

    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
    ) {
        Text(
            text = "Reseñas del curso",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(comments) { comment ->
                CommentCard(comment)
            }
        }
    }
}
