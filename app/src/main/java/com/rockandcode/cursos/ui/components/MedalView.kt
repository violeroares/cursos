package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rockandcode.cursos.domain.models.RangeMedal

@Composable
fun MedalView(
    medal: RangeMedal?,
    label: String,
    highlighted: Boolean = false,
    size: Dp = 80.dp, // Valor por defecto
    iconSize: TextUnit = 28.sp,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier =
                Modifier
                    .size(size)
                    .clip(CircleShape)
                    .background(
                        when {
                            medal == null -> Color.Gray
                            highlighted -> Color(0xFFB2FFB2)
                            else -> Color.LightGray
                        },
                    ),
            contentAlignment = Alignment.Center,
        ) {
            Text(medal?.icon ?: "❔", fontSize = iconSize)
        }
        Spacer(Modifier.height(4.dp))
        Text(label, fontSize = 12.sp)
        Text(medal?.name ?: "—", fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}
