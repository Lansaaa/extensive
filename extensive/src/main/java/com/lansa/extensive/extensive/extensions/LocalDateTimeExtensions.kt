package com.lansa.extensive.extensive.extensions

import com.lansa.extensive.extensive.zoneOffset
import java.time.LocalDate
import java.time.LocalDateTime


val now: LocalDateTime
    get() = LocalDateTime.now()

val today: LocalDate
    get() = LocalDateTime.now().toLocalDate()

fun LocalDateTime.hoursMinutes(): String {
    return "${hour.print()}:${minute.print()}"
}

fun LocalDateTime.toMillis(): Long {
    return this.toInstant(zoneOffset).toEpochMilli()
}