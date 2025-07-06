package com.rockandcode.cursos.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.SlowMotionVideo
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rockandcode.cursos.ui.screens.CartViewModel

@Composable
fun BottomBar(
    controller: NavHostController,
    cartViewModel: CartViewModel = hiltViewModel(),
) {
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val isDarkTheme = isSystemInDarkTheme()
    val myColor = Color(0xFF2B1BBA)
    val cartItemCount = cartViewModel.items.size

    NavigationBar(
        containerColor = if (!isDarkTheme) myColor else MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),
        modifier =
            Modifier
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
    ) {
        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == "home" } == true,
            onClick = { controller.navigate("home") },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home",
                    // tint = MaterialTheme.colorScheme.primary,
                )
            },
            label = { Text("Home") },
            colors =
                NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = if (!isDarkTheme) Color(0xFF4F3BC4) else MaterialTheme.colorScheme.secondaryContainer,
                    // opcional si no querés fondo distinto al seleccionar
                ),
        )

        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == "cart" } == true,
            onClick = { controller.navigate("cart") },
            icon = {
                BadgedBox(
                    badge = {
                        if (cartItemCount > 0) {
                            Badge {
                                Text(cartItemCount.toString())
                            }
                        }
                    },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = "Carrito",
                    )
                }
            },
            label = { Text("Carrito") },
            colors =
                NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = Color.Transparent, // opcional si no querés fondo distinto al seleccionar
                ),
        )

        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == "profile" } == true,
            onClick = { controller.navigate("profile") },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.SlowMotionVideo,
                    contentDescription = "Profile",
                    // tint = MaterialTheme.colorScheme.primary,
                )
            },
            label = { Text("Mi aprendizaje") },
            colors =
                NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = Color.Transparent, // opcional si no querés fondo distinto al seleccionar
                ),
        )

        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == "profile" } == true,
            onClick = { controller.navigate("profile") },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profile",
                    // tint = MaterialTheme.colorScheme.primary,
                )
            },
            label = { Text("Mi Perfil") },
            colors =
                NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = Color.Transparent, // opcional si no querés fondo distinto al seleccionar
                ),
        )
    }
}
