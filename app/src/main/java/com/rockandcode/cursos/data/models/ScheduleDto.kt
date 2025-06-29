package com.rockandcode.cursos.data.models

import com.rockandcode.cursos.domain.models.Schedule

data class ScheduleDto(
    val dayOfWeek: String,
    val startTime: String,
    val endTime: String,
) {
    fun toDomain() = Schedule(dayOfWeek, startTime, endTime)
}
