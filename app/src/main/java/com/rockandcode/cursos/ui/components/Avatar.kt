package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rockandcode.cursos.R
import com.rockandcode.cursos.utils.decodeBase64ToBitmap

@Composable
fun Avatar(
    avatarUrl: String?,
    modifier: Modifier = Modifier,
    avatarSize: Dp = 48.dp, // Valor por defecto
) {
    val isDarkTheme = isSystemInDarkTheme()
    val model =
        remember(avatarUrl) {
            when {
                avatarUrl.isNullOrBlank() -> null
                avatarUrl.startsWith("data:image") -> decodeBase64ToBitmap(avatarUrl)
                else -> "$avatarUrl&size=256&bold=true&background=random&color=ffffff"
            }
        }

    if (model != null) {
        AsyncImage(
            model = model,
            contentDescription = "avatar",
            modifier =
                modifier
                    .size(avatarSize)
                    .border(1.5.dp, MaterialTheme.colorScheme.surfaceBright, CircleShape)
                    .border(3.dp, MaterialTheme.colorScheme.surface, CircleShape)
                    .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
    } else {
        Image(
            painterResource(
                id = if (isDarkTheme) R.drawable.ic_launcher_foreground else R.drawable.ic_launcher_foreground,
            ),
            contentDescription = "default avatar",
            modifier =
                modifier
                    .size(avatarSize)
                    .border(1.5.dp, MaterialTheme.colorScheme.surfaceBright, CircleShape)
                    .border(3.dp, MaterialTheme.colorScheme.surface, CircleShape)
                    .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
    }
}
