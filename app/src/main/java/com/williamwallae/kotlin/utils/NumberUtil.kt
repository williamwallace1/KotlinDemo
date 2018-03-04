package com.williamwallae.kotlin.utils

import java.util.*

val hash = hashMapOf(1 to "xiaoming", 4 to "xiaoli")
val set = hashSetOf<Float>(3F)
val list = arrayListOf(1, 2, 3)

fun add(x: Int, y: Int): String {
    return (x + y).toString()
}

fun Date.isTuesday() = day == 2

fun String.getLastChar() = this.get(this.length - 1)