package com.rockandcode.cursos.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rockandcode.cursos.R

// Set of Material typography styles to start with
// val Typography =
//    Typography(
//        bodyLarge =
//            TextStyle(
//                fontFamily = FontFamily.Default,
//                fontWeight = FontWeight.Normal,
//                fontSize = 16.sp,
//                lineHeight = 24.sp,
//                letterSpacing = 0.5.sp,
//            ),
//        /* Other default text styles to override
//    titleLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 22.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
//    ),
//    labelSmall = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    )
//         */
//    )

// val RalewayVariable =
//    FontFamily(
//        Font(R.font.raleway_variable),
//    )

val RalewayFontFamily =
    FontFamily(
        Font(R.font.raleway_regular, weight = FontWeight.Normal),
        Font(R.font.raleway_light, weight = FontWeight.Light),
        Font(R.font.raleway_medium, weight = FontWeight.Medium),
        Font(R.font.raleway_bold, weight = FontWeight.Bold),
    )

// val AppTypography =
//    Typography(
//        displayLarge = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium), // 500
//        displayMedium = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        displaySmall = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        headlineLarge = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        headlineMedium = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        headlineSmall = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        titleLarge = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        titleMedium = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        titleSmall = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        bodyLarge = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        bodyMedium = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        bodySmall = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        labelLarge = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        labelMedium = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//        labelSmall = TextStyle(fontFamily = RalewayVariable, fontWeight = FontWeight.Medium),
//    )

val AppTypography =
    Typography(
        displayLarge =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 57.sp,
                lineHeight = 64.sp,
                letterSpacing = (-0.25).sp,
            ),
        displayMedium =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 45.sp,
                lineHeight = 52.sp,
                letterSpacing = 0.sp,
            ),
        displaySmall =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 36.sp,
                lineHeight = 44.sp,
                letterSpacing = 0.sp,
            ),
        headlineLarge =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 32.sp,
                lineHeight = 40.sp,
                letterSpacing = 0.sp,
            ),
        headlineMedium =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 28.sp,
                lineHeight = 36.sp,
                letterSpacing = 0.sp,
            ),
        headlineSmall =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                lineHeight = 32.sp,
                letterSpacing = 0.sp,
            ),
        titleLarge =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp,
            ),
        titleMedium =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.15.sp,
            ),
        titleSmall =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp,
            ),
        bodyLarge =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.sp,
            ),
        bodyMedium =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
            ),
        bodySmall =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.4.sp,
            ),
        labelLarge =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp,
            ),
        labelMedium =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
            ),
        labelSmall =
            TextStyle(
                fontFamily = RalewayFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
            ),
    )
