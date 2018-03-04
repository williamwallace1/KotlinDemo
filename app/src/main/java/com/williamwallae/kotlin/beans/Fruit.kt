package com.williamwallae.kotlin.beans

sealed class Fruit {
    class Apple: Fruit()
    class Banana: Fruit()
    object Other: Fruit()
}