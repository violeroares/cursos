package com.rockandcode.cursos.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.SignalCellularAlt
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.rockandcode.cursos.domain.models.Course
import com.rockandcode.cursos.ui.components.CourseCertificateCard
import com.rockandcode.cursos.ui.components.CourseCommentsSection
import com.rockandcode.cursos.ui.components.CourseDescription
import com.rockandcode.cursos.ui.components.CourseDocuments
import com.rockandcode.cursos.ui.components.CourseIncludes
import com.rockandcode.cursos.ui.components.CourseInstructors
import com.rockandcode.cursos.ui.components.CourseRequirements
import com.rockandcode.cursos.ui.components.CourseTags
import com.rockandcode.cursos.ui.components.CourseTopics
import com.rockandcode.cursos.ui.components.CourseVideos
import com.rockandcode.cursos.utils.formatPrice

@Composable
fun CourseDetailScreen(
    courseId: Int,
    viewModel: CourseDetailViewModel = hiltViewModel(),
    cartViewModel: CartViewModel,
    checkoutViewModel: CheckoutViewModel,
    onBack: () -> Unit,
    controller: NavHostController,
) {
    val state by viewModel.uiState.collectAsState()
    val certificate by viewModel.certificate.collectAsState()
    val context = LocalContext.current
    val isDarkTheme = isSystemInDarkTheme()
    val listState = rememberLazyListState()

    LaunchedEffect(courseId) {
        viewModel.loadCourse(courseId)
    }

    val showBottomBar by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 4 || listState.firstVisibleItemScrollOffset > 800
        }
    }

    when (val uiState = state.uiState) {
        is CourseDetailUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is CourseDetailUiState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = uiState.message, color = MaterialTheme.colorScheme.error)
            }
        }

        is CourseDetailUiState.Success -> {
            val course = uiState.course
            val progress = uiState.userProgress?.percentCompleted(course) ?: 0.0

            Scaffold(
                contentWindowInsets = WindowInsets(0),
                bottomBar = {
                    if (!uiState.isPurchased && showBottomBar) {
                        ComprarBottomBar(
                            course = course,
                            isDarkTheme = isDarkTheme,
                            cartItemCount = cartViewModel.items.size,
                            onAddToCart = {
                                cartViewModel.addItem(course)
                                Toast.makeText(context, "Curso agregado al carrito", Toast.LENGTH_SHORT).show()
                            },
                            onBuyNow = {
                                checkoutViewModel.setCourses(listOf(course))
                                controller.navigate("checkout/user")
                            },
                            onCartClick = { controller.navigate("cart") },
                        )
                    }
                },
            ) { padding ->
                LazyColumn(
                    state = listState,
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(padding),
                    contentPadding = PaddingValues(bottom = 96.dp),
                ) {
                    item {
                        // CourseImg + Back
                        Box(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .height(240.dp),
                        ) {
                            AsyncImage(
                                model = course.thumbnailUrl,
                                contentDescription = course.title,
                                modifier =
                                    Modifier
                                        .fillMaxSize()
                                        .clip(
                                            RoundedCornerShape(
                                                bottomStart = 24.dp,
                                                bottomEnd = 24.dp,
                                            ),
                                        ),
                                contentScale = ContentScale.Crop,
                            )

                            IconButton(
                                onClick = onBack,
                                modifier =
                                    Modifier
                                        .align(Alignment.TopStart)
                                        .padding(top = 48.dp, start = 16.dp)
                                        .background(
                                            color = Color.Black.copy(alpha = 0.4f),
                                            shape = CircleShape,
                                        ).size(36.dp),
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Atrás",
                                    tint = Color.White,
                                )
                            }
                        }

                        // Title
                        Text(
                            course.title,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            modifier =
                                Modifier.padding(
                                    top = 16.dp,
                                    start = 16.dp,
                                    end = 16.dp,
                                    bottom = 4.dp,
                                ),
                        )
                        // SubTitle
                        Text(
                            course.subTitle,
                            style = MaterialTheme.typography.titleMedium.copy(lineHeight = 22.sp),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                        )

                        // Author
                        course.author?.let { author ->
                            Row(
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    "Creado por: ",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color.Gray,
                                )
                                Text(
                                    author.name,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }

                        // Stars
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                        ) {
                            // ⭐ Parte izquierda: número + estrellas
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f),
                            ) {
                                Text(
                                    text = "%.1f".format(course.rating),
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(end = 8.dp, bottom = 4.dp),
                                    color = Color(0xFFF7C33F),
                                )

                                repeat(5) { index ->
                                    val icon =
                                        if (index < course.rating.toInt()) {
                                            Icons.Filled.Star
                                        } else {
                                            Icons.Outlined.StarBorder
                                        }

                                    Icon(
                                        imageVector = icon,
                                        contentDescription = null,
                                        tint = Color(0xFFF7C33F),
                                        modifier = Modifier.size(20.dp),
                                    )
                                }
                            }

                            // 📝 Parte derecha: valoraciones
                            Text(
                                text = "${course.ratingCount} valoraciones",
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.Gray,
                                textAlign = TextAlign.End,
                            )
                        }

                        // Total students
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.People,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.padding(end = 8.dp),
                            )
                            Text(
                                text = "${course.totalStudents} estudiantes",
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.Gray,
                                fontWeight = FontWeight.Medium,
                            )
                        }

                        // Last Update
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Refresh,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.padding(end = 8.dp),
                            )
                            Text(
                                text = "Ultima actualización: ${course.updatedAt}",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray,
                            )
                        }

                        // Course level:
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.SignalCellularAlt,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.padding(end = 8.dp),
                            )
                            Text(
                                text = "Nivel: ${course.level.name}",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray,
                            )
                        }

                        // Boton comprar
                        if (!uiState.isPurchased) {
                            ComprarBottomBar(
                                course = course,
                                isDarkTheme = isDarkTheme,
                                cartItemCount = cartViewModel.items.size,
                                onAddToCart = {
                                    cartViewModel.addItem(course)
                                    Toast.makeText(context, "Curso agregado al carrito", Toast.LENGTH_SHORT).show()
                                },
                                onBuyNow = {
                                    checkoutViewModel.setCourses(listOf(course))
                                    controller.navigate("checkout/user")
                                },
                                onCartClick = { controller.navigate("cart") },
                            )
                        }

                        // Topics
                        if (!uiState.isPurchased && course.topics.isNotEmpty()) {
                            CourseTopics(course = course)
                        }

                        // Includes
                        if (!uiState.isPurchased) {
                            CourseIncludes(course)
                        }

                        // Progreso y certitifado de curso completado
                        if (uiState.isPurchased) {
                            CourseCertificateCard(
                                progress = progress,
                                certificateUrl = certificate?.certificateUrl,
                            )
                        }

                        // Videos
                        CourseVideos(
                            course = course,
                            userProgress = uiState.userProgress,
                            onClick = { courseId, videoId ->
                                viewModel.toggleWatched(
                                    courseId,
                                    videoId,
                                )
                            },
                            isPurchased = uiState.isPurchased,
                        )

                        // Requeriments
                        if (!uiState.isPurchased) {
                            CourseRequirements(course)
                        }

                        // Materiales del curso
                        if (uiState.isPurchased && course.documents.isNotEmpty()) {
                            CourseDocuments(course)
                        }

                        // Instructor/es
                        CourseInstructors(
                            course = course,
                            onClick = { instructorId -> controller.navigate("instructor/$instructorId") },
                        )

                        // Descripcion
                        CourseDescription(course.description)

                        // Comments
                        CourseCommentsSection(comments = course.comments)

                        // Tags
                        if (course.tags.isNotEmpty()) {
                            CourseTags(course, onClick = {})
                        }

                        Spacer(Modifier.height(48.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ComprarBottomBar(
    course: Course,
    isDarkTheme: Boolean,
    onAddToCart: () -> Unit,
    onBuyNow: () -> Unit,
    cartItemCount: Int,
    onCartClick: () -> Unit,
) {
    Column {
        // Precio + carrito (en la misma fila)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.Bottom) {
                Text("Valor del curso", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(6.dp))
                Text(
                    text = if (!course.isFree) formatPrice(course.price) else "Gratuito",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                )
            }

            if (cartItemCount > 0) {
                IconButton(onClick = onCartClick) {
                    BadgedBox(
                        badge = {
                            Badge {
                                Text(
                                    cartItemCount.toString(),
                                    style = MaterialTheme.typography.labelSmall,
                                )
                            }
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ShoppingCart,
                            contentDescription = "Ir al carrito",
                            tint = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
            }
        }

        // Botones de acción
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedButton(
                onClick = onAddToCart,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFF7B2FC5)),
            ) {
                Text("Añadir al carrito", fontWeight = FontWeight.SemiBold, maxLines = 1)
            }

            Button(
                onClick = onBuyNow,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(8.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = if (!isDarkTheme) Color(0xFF7B2FC5) else MaterialTheme.colorScheme.primary,
                        contentColor = if (!isDarkTheme) Color.White else MaterialTheme.colorScheme.onPrimary,
                    ),
            ) {
                Text("Comprar ahora", fontWeight = FontWeight.SemiBold, maxLines = 1)
            }
        }
    }
}
