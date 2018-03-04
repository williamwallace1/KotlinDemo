package com.williamwallae.kotlin.beans

data class Person(var name: String, var age: Int) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return when {
            this.age > other.age -> 1
            this.age == other.age -> 0
            else -> -1
        }
    }
}