package com.lansa.extensive

import com.lansa.extensive.extensions.toMillis
import java.time.LocalDateTime
import java.util.*


object Utils {

    const val DEFAULT_FADE_IN_DURATION = 1000L

    fun now(): LocalDateTime = LocalDateTime.now()

    fun nowMillis(): Long = now().toMillis()

    fun randomUUID(): String = UUID.randomUUID().toString()
}