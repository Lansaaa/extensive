package com.lansa.extensive.extensive.extensions


fun Float?.orDefault(value: Float): Float {
    return this ?: value
}

fun Float?.orZero(): Float {
    return this ?: 0f
}