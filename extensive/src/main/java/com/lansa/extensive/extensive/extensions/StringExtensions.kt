package com.lansa.extensive.extensive.extensions

import android.util.Base64
import com.lansa.extensive.extensive.*
import java.text.ParsePosition
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


fun String?.firstLetter(uppercase: Boolean = true): String {
    return if (!this.isNullOrEmpty()) {
        val letter = this.first()
        return if (uppercase) {
            letter.toUpperCase()
        } else {
            letter
        }.toString()
    } else {
        ""
    }
}

fun String?.toDate(pattern: String = defaultDateTimeFormat): LocalDateTime? {
    val stringDate = this
    val formatter = DateTimeFormatter.ofPattern(pattern)
    return LocalDateTime.parse(stringDate, formatter)
}

fun String?.stringToLong(
    parsePosition: ParsePosition = ParsePosition(0),
    timeZone: TimeZone = utcTimeZone
): Long {
    return this.stringToDate(parsePosition, timeZone).time
}

fun String?.stringToDate(
    parsePosition: ParsePosition = ParsePosition(0),
    timeZone: TimeZone = utcTimeZone
): Date {
    val value = this ?: defaultDateTimeString
    formatter.timeZone = timeZone
    return formatter.parse(value, parsePosition)!!
}

fun String?.toBase64String(): String {
    return Base64.encodeToString(this?.toByteArray(charset(UTF_8)), Base64.NO_WRAP)
}

fun String?.toTitleCase(): String {
    return this?.split(" ")?.joinToString(" ") { it.capitalize(locale()) } ?: ""
}