package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Accessibility
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.RangeMedal

@Composable
fun MedalView(
    medal: RangeMedal?,
    label: String,
) {
    val isDarkTheme = isSystemInDarkTheme()
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier =
                Modifier
                    .width(100.dp)
                    .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier =
                    Modifier
                        .size(150.dp),
                contentAlignment = Alignment.Center,
            ) {
                AsyncImage(
                    model = medal?.icon,
                    contentDescription = medal?.number.toString(),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize(),
                )

                // Círculo violeta con número centrado
                Box(
                    modifier =
                        Modifier
                            .size(60.dp)
                            .offset(y = (-13).dp)
                            .background(color = Color(0xFF7B2FC5), shape = CircleShape)
                            .clip(CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        modifier =
                            Modifier
                                .offset(y = (-4).dp),
                        text = medal?.number.toString(),
                        style =
                            MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 34.sp,
                                color = Color.White,
                            ),
                    )
                }
            }

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = label,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.onBackground,
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Columna con la info del próximo nivel y beneficios
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
        ) {
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    modifier = Modifier.padding(bottom = 2.dp),
                    text = "Próximo nivel:",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = medal?.number?.plus(1).toString(),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Faltan 130 puntos para alcanzar el nivel",
                style = MaterialTheme.typography.bodyLarge,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
            )
            Spacer(Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 3.dp),
            ) {
                Icon(
                    imageVector = Icons.Outlined.Accessibility,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                )
                Spacer(Modifier.width(5.dp))
                Text(
                    text = "Beneficios que obtendrás:",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(Modifier.height(2.dp))

            medal?.benefits?.forEach { benefit ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 3.dp),
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Check,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                    )
                    Spacer(Modifier.width(5.dp))
                    Text(
                        text = benefit.description,
                        style = MaterialTheme.typography.titleMedium.copy(lineHeight = 18.sp, fontSize = 14.sp),
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
        }
    }
}
