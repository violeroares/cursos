package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.Category

@Composable
fun HomeCategoryCard(
    category: Category,
    modifier: Modifier = Modifier,
    onClick: (Category) -> Unit = {},
) {
    Box(
        modifier =
            modifier
                .width(200.dp)
                .height(120.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable { onClick(category) },
    ) {
        AsyncImage(
            model = category.imageUrl,
            contentDescription = category.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )

        // Opcional: overlay con nombre
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .background(Color.Black.copy(alpha = 0.4f))
                    .padding(8.dp),
        ) {
            Text(
                text = category.name,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
                maxLines = 1,
            )
        }
    }
}
