package com.rockandcode.cursos.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun RoundedTextInput(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    icon: ImageVector? = null,
    iconDescription: String = "Editar",
    enabled: Boolean = true,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    trailingContent: @Composable (() -> Unit)? = null, // nuevo slot
) {
    var isFocused by remember { mutableStateOf(false) }
    val isDarkTheme = isSystemInDarkTheme()
    val colors = MaterialTheme.colorScheme

    Box(
        modifier =
            modifier
                .fillMaxWidth()
                .shadow(8.dp, shape = RoundedCornerShape(50))
                .background(color = colors.surface, shape = RoundedCornerShape(50))
                .height(45.dp)
                .border(
                    width = 1.dp,
                    color = if (isFocused) Color(0xFF7B2FC5) else colors.outlineVariant,
                    shape = RoundedCornerShape(50),
                ).padding(horizontal = 16.dp, vertical = 13.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                enabled = enabled,
                textStyle =
                    MaterialTheme.typography.bodyLarge.copy(
                        color = if (enabled) colors.onSurface else colors.outline,
                    ),
                singleLine = true,
                modifier =
                    Modifier
                        .weight(1f)
                        .onFocusChanged { isFocused = it.isFocused },
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = TextStyle(color = colors.outline),
                        )
                    }
                    innerTextField()
                },
            )

            if (trailingContent != null) {
                Spacer(Modifier.width(8.dp))
                trailingContent()
            }

            if (icon != null) {
                Spacer(Modifier.width(8.dp))
                Icon(
                    imageVector = icon,
                    contentDescription = iconDescription,
                    tint =
                        if (enabled) {
                            if (isDarkTheme) Color(0xFFD0A8FF) else Color(0xFF7B2FC5)
                        } else {
                            colors.outline
                        },
                    modifier = Modifier.size(20.dp),
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
}
