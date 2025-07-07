package com.rockandcode.cursos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Accessibility
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.RangeMedal
import com.rockandcode.cursos.ui.components.AppHeader

@Composable
fun MedalScreen(
    controller: NavHostController,
    viewModel: MedalViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    val isDarkTheme = isSystemInDarkTheme()

    when (val uiState = state) {
        is MedalUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is MedalUiState.Error -> {
            Text("Error: ${uiState.message}")
        }

        is MedalUiState.Success -> {
            Scaffold(
                topBar = {
                    AppHeader(
                        title = "Logros y beneficios",
                        onBack = { controller.popBackStack() },
                    )
                },
                contentWindowInsets = WindowInsets(0),
            ) { paddingValues ->
                LazyColumn(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = paddingValues,
                ) {
                    items(uiState.medals) { medal ->
                        MedalItem(medal, isDarkTheme)
                    }
                    item {
                        Spacer(modifier = Modifier.height(48.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun MedalItem(
    medal: RangeMedal,
    isDarkTheme: Boolean,
) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = RoundedCornerShape(16.dp),
        colors =
            CardDefaults.cardColors(
                containerColor = if (!isDarkTheme) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceContainer,
            ),
    ) {
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
                        model = medal.icon,
                        contentDescription = medal.number.toString(),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize(),
                    )

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
                            text = medal.number.toString(),
                            style =
                                MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 34.sp,
                                    color = Color.White,
                                ),
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp),
            ) {
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
                        text = "Beneficios de este nivel:",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Spacer(Modifier.height(2.dp))

                medal.benefits.forEach { benefit ->
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
                            style =
                                MaterialTheme.typography.titleMedium.copy(
                                    lineHeight = 18.sp,
                                    fontSize = 14.sp,
                                ),
                            fontWeight = FontWeight.Normal,
                        )
                    }
                }
            }
        }
    }
}
