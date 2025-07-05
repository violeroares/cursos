package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.Comment

@Composable
fun CommentCard(
    comment: Comment,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier =
            modifier
                .width(280.dp)
                .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = comment.avatarUrl,
                    contentDescription = "Avatar",
                    modifier =
                        Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = comment.userName,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = comment.date,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Estrellas
            Row(verticalAlignment = Alignment.CenterVertically) {
                repeat(5) { index ->
                    Icon(
                        imageVector = if (index < comment.rating) Icons.Filled.Star else Icons.Outlined.StarBorder,
                        contentDescription = null,
                        tint = Color(0xFFF7C33F),
                        modifier = Modifier.size(16.dp),
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = comment.text,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}
