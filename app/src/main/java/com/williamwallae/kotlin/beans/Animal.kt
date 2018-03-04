package com.williamwallae.kotlin.beans

// open | abstract
abstract class Animal(private val eyeColor: Int) {
    fun test() : Int = eyeColor
}