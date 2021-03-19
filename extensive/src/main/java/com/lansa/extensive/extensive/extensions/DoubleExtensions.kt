package com.lansa.extensive.extensive.extensions


fun Double?.orDefault(value: Double): Double {
    return this ?: value
}

fun Double?.orZero(): Double {
    return this ?: 0.0
}