package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.Certificate

data class CertificateDto(
    val courseId: Int,
    val userId: Int,
    val certificateUrl: String,
) {
    fun toDomain() = Certificate(courseId, userId, certificateUrl)
}
