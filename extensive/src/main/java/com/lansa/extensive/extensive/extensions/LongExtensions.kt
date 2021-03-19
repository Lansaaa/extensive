package com.lansa.extensive.extensive.extensions


fun Long?.orDefault(value: Long): Long {
    return this ?: value
}

fun Long?.orZero(): Long {
    return this ?: 0L
}

fun Long.padStart(padding: Int, char: Char): String {
    return toString().padStart(padding, char)
}

fun Long.print(): String {
    return padStart(2, '0')
}