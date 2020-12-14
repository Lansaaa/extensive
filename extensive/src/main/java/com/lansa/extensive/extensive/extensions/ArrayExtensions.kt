package com.lansa.extensive.extensions

fun Array<Int>.toStringArray(): Array<String> {
    return map { it.toString() }.toTypedArray()
}
