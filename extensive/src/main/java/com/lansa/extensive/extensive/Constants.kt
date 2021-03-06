package com.lansa.extensive.extensive

import java.text.SimpleDateFormat
import java.util.*


const val defaultDateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

const val defaultDateTimeString: String = "1970-01-01T00:00:00.000Z"

val defaultTimeZone: TimeZone = TimeZone.getDefault()

val formatter = SimpleDateFormat(defaultDateTimeFormat, locale())

fun locale(): Locale = Locale.getDefault()

const val UTF_8 = "UTF-8"
const val UTC = "UTC"

val utcTimeZone: TimeZone = TimeZone.getTimeZone(UTC)