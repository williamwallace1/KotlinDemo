package com.williamwallae.kotlin.beans

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(1, 2, 3), ORANGE(4, 5, 6), YELLOW(7, 8, 9);

    fun rgb() = (r * 256 + g) * 256 + b
}

