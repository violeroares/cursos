package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeSectionTitle(
    title: String,
    onClick: () -> Unit = {},
    showButton: Boolean = false,
) {
    val isDarkTheme = isSystemInDarkTheme()
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = if (!isDarkTheme) Color(0xFF2B1BBA) else MaterialTheme.colorScheme.onBackground,
        )
        if (showButton) {
            TextButton(
                onClick = onClick,
                modifier =
                    Modifier
                        .background(
                            color = if (!isDarkTheme) Color(0xFF2B1BBA) else MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(24.dp),
                        ).height(32.dp)
                        .defaultMinSize(minHeight = 1.dp, minWidth = 1.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                colors =
                    ButtonDefaults.textButtonColors(
                        contentColor = Color.White,
                    ),
            ) {
                Text(
                    "Ver más",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}
