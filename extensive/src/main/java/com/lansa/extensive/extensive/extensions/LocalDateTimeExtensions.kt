package com.lansa.extensive.extensions

import java.time.LocalDateTime


fun LocalDateTime.hoursMinutes(): String {
    return "${hour.print()}:${minute.print()}"
}

fun LocalDateTime.toMillis(): Long {
    return this.toInstant(zoneOffset).toEpochMilli()
}