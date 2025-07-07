package com.rockandcode.cursos.ui.screens

import RoundedTextInput
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.rockandcode.cursos.ui.components.AppHeader

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    categoriesViewModel: FiltersViewModel = hiltViewModel(),
    controller: NavHostController,
    onLogout: () -> Unit,
) {
    val state by viewModel.uiState.collectAsState()
    val isDarkTheme = isSystemInDarkTheme()
    var name by remember { mutableStateOf(viewModel.profileInfo.name) }
    var email by remember { mutableStateOf(viewModel.profileInfo.email) }
    var phone by remember { mutableStateOf(viewModel.profileInfo.phoneNumber) }
    var street by remember { mutableStateOf(viewModel.profileInfo.addressStreet) }
    var number by remember { mutableStateOf(viewModel.profileInfo.addressNumber) }
    var gender by remember { mutableStateOf(viewModel.profileInfo.gender) }
    var birthDate by remember { mutableStateOf(viewModel.profileInfo.birthDate) }
    val allCategories by categoriesViewModel.categories.collectAsState()
    val selectedCategories = remember { mutableStateListOf<Int>() }

    when (val uiState = state) {
        is ProfileUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is ProfileUiState.Error -> {
            Text("Error: ${uiState.message}")
        }

        is ProfileUiState.Success -> {
            val user = uiState.user

            Scaffold(
                topBar = {
                    AppHeader(
                        title = "Mi perfil",
                        onBack = { controller.popBackStack() },
                        actions = {
                            // Ícono para cambiar contraseña
                            IconButton(onClick = { /* Acción */ }) {
                                Icon(
                                    imageVector = Icons.Default.Lock,
                                    contentDescription = "Cambiar contraseña",
                                    tint = Color.White,
                                )
                            }
                            // Ícono para cerrar sesión
                            IconButton(onClick = onLogout) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                    contentDescription = "Cerrar sesión",
                                    tint = Color.White,
                                )
                            }
                        },
                    )
                },
                contentWindowInsets = WindowInsets(0),
            ) { innerPadding ->
                Column(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(
                        modifier = Modifier.size(120.dp),
                        contentAlignment = Alignment.BottomEnd,
                    ) {
                        AsyncImage(
                            model = user.avatarUrl,
                            contentDescription = null,
                            modifier =
                                Modifier
                                    .fillMaxSize()
                                    .clip(CircleShape),
                        )

                        Box(
                            modifier =
                                Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primary)
                                    .clickable { /* Acción para editar imagen */ },
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Editar imagen",
                                tint = Color.White,
                                modifier = Modifier.size(22.dp),
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Hola, ${user.name}!",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(Modifier.height(2.dp))

                    Text(
                        text = user.email,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Fecha de nac.", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(6.dp))
                            RoundedTextInput(birthDate, { birthDate = it }, "Fecha de nac.", Icons.Default.CalendarMonth, "Editar fecha")
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Género", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(6.dp))
                            RoundedTextInput(gender, { gender = it }, "Femenino", Icons.Default.KeyboardArrowDown, "Editar género")
                        }
                    }

                    Spacer(Modifier.height(2.dp))

                    Text(
                        "Teléfono",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(Modifier.height(6.dp))
                    RoundedTextInput(phone, { phone = it }, "Teléfono", Icons.Default.Edit, "Editar teléfono")

                    Spacer(Modifier.height(2.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Calle", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(6.dp))
                            RoundedTextInput(street, { street = it }, "Calle", Icons.Default.Edit, "Editar calle")
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Número", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(6.dp))
                            RoundedTextInput(number, { number = it }, "Número", Icons.Default.Edit, "Editar número")
                        }
                    }

                    Spacer(Modifier.height(4.dp))

                    Text(
                        "Seleccione las categorias de su interés:",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        allCategories.forEach { category ->
                            FilterChip(
                                selected = selectedCategories.contains(category.id),
                                onClick = {
                                    if (selectedCategories.contains(category.id)) {
                                        selectedCategories.remove(category.id)
                                    } else {
                                        selectedCategories.add(category.id)
                                    }
                                },
                                label = { Text(category.name) },
                            )
                        }
                    }

                    Spacer(Modifier.height(18.dp))

                    Button(
                        onClick = {
                            viewModel.profileInfo =
                                viewModel.profileInfo.copy(
                                    name = name,
                                    email = email,
                                    phoneNumber = phone,
                                    addressStreet = street,
                                    addressNumber = number,
                                )
                        },
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                        enabled = listOf(phone, street, number, gender, birthDate).all { it.isNotBlank() },
                        shape = RoundedCornerShape(40.dp),
                        colors =
                            ButtonDefaults.buttonColors(
                                containerColor = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primary,
                                contentColor = if (!isDarkTheme) Color.White else MaterialTheme.colorScheme.onPrimary,
                            ),
                    ) {
                        Text("Guardar cambios", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyLarge)
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
