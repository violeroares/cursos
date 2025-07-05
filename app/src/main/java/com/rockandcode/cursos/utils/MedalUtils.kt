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
