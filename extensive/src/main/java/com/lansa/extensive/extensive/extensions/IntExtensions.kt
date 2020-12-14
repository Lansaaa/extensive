package com.lansa.extensive.extensive.extensions

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.TypedValue
import java.util.concurrent.TimeUnit


fun Int.millisToPeriod(): Array<Long> {
    var millis = this * 1000L

    val days: Long = TimeUnit.MILLISECONDS.toDays(millis)
    millis -= TimeUnit.DAYS.toMillis(days)

    val hours: Long = TimeUnit.MILLISECONDS.toHours(millis)
    millis -= TimeUnit.HOURS.toMillis(hours)

    val minutes: Long = TimeUnit.MILLISECONDS.toMinutes(millis)
    millis -= TimeUnit.MINUTES.toMillis(minutes)

    val seconds: Long = TimeUnit.MILLISECONDS.toSeconds(millis)

    return arrayOf(days, hours, minutes, seconds)
}

fun Int.padStart(padding: Int, char: Char): String = toString().padStart(padding, char)

fun Int.print(): String = padStart(2, '0')

fun Int.secondsToPeriod(): Array<Long> = (this * 1000).millisToPeriod()

fun Int.getColor(context: Context): Int {
    val typedValue = TypedValue()
    val a: TypedArray = context.obtainStyledAttributes(typedValue.data, intArrayOf(this))
    val color = a.getColor(0, Color.BLACK)
    a.recycle()
    return color
}