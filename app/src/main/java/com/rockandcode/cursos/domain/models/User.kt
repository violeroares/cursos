package com.rockandcode.cursos.domain.models

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val avatarUrl: String,
    val purchasedCourses: List<Course>,
    val progressByCourse: List<UserCourseProgress>,
    val score: Int,
    val preferredCategories: List<Category>,
    val birthDate: String,
    val addressStreet: String,
    val addressNumber: String,
    val phoneNumber: String,
    val gender: String,
)
