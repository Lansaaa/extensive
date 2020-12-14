package com.lansa.extensive.extensions

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


fun Long.toLocalDateTime(
    pattern: String = defaultDateTimeFormat,
    zoneOffset: ZoneOffset = ZoneOffset.UTC
): LocalDateTime? {
    return getDateString(pattern, zoneOffset).toDate()
}

fun Long.getDateString(
    pattern: String = defaultDateTimeFormat,
    zoneOffset: ZoneOffset = ZoneOffset.UTC
): String {
    return LocalDateTime
        .ofInstant(
            Instant.ofEpochMilli(this)
                .atZone(ZoneOffset.UTC)
                .toInstant(),
            zoneOffset
        )
        .format(
            DateTimeFormatter.ofPattern(pattern, locale())
        )
}

fun Long.padStart(padding: Int, char: Char): String {
    return toString().padStart(padding, char)
}

fun Long.print(): String {
    return padStart(2, '0')
}