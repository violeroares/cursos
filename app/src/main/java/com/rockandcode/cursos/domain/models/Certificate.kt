package com.rockandcode.cursos.domain.models

data class Certificate(
    val courseId: Int,
    val userId: Int,
    val certificateUrl: String, // link al pdf o web del certificado
)
