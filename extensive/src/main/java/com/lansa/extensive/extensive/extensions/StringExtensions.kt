package com.lansa.extensive.extensive.extensions

import android.graphics.Color
import android.util.Base64
import com.lansa.extensive.extensive.*
import java.text.ParsePosition
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

fun String?.stringToDate(parsePosition: ParsePosition = ParsePosition(0), timeZone: TimeZone = utcTimeZone): Date {
    val value = this ?: defaultDateTimeString
    formatter.timeZone = timeZone
    return formatter.parse(value, parsePosition)!!
}

fun String?.stringToLong(parsePosition: ParsePosition = ParsePosition(0), timeZone: TimeZone = utcTimeZone): Long {
    return this.stringToDate(parsePosition, timeZone).time
}

fun String?.toBase64String(): String {
    return Base64.encodeToString(this?.toByteArray(charset(UTF_8)), Base64.NO_WRAP)
}

fun String?.toColor(ifNull: Int = Color.TRANSPARENT): Int {
    return if (this.isNullOrEmpty()) {
        ifNull
    } else {
        try {
            Color.parseColor(this)
        } catch (ex: Exception) {
            ifNull
        }
    }
}

fun String?.toTitleCase(): String {
    return this?.toLowerCase()?.split(" ")?.joinToString(" ") { it.capitalize(locale()) } ?: ""
}