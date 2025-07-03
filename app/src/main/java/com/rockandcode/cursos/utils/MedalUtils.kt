package com.rockandcode.cursos.utils

import com.rockandcode.cursos.domain.models.RangeMedal

fun getMedalProgress(
    score: Int,
    allMedals: List<RangeMedal>,
): Triple<RangeMedal?, RangeMedal?, RangeMedal?> {
    val sorted = allMedals.sortedBy { it.threshold }

    var previous: RangeMedal? = null
    var current: RangeMedal? = null
    var next: RangeMedal? = null

    for ((index, medal) in sorted.withIndex()) {
        if (score >= medal.threshold) {
            previous = current
            current = medal
            next = sorted.getOrNull(index + 1)
        } else {
            next = medal
            break
        }
    }

    return Triple(previous, current, next)
}

fun formatDuration(totalSeconds: Int): String {
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    return when {
        hours > 0 && minutes > 0 -> "${hours}h ${minutes}m"
        hours > 0 -> "${hours}h"
        else -> "${minutes}m"
    }
}
