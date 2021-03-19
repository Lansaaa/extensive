package com.lansa.extensive.extensive.extensions


fun Array<Int>.toStringArray(): Array<String> {
    return map { it.toString() }.toTypedArray()
}
