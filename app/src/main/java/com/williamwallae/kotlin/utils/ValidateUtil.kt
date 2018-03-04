package com.williamwallae.kotlin.utils

import com.williamwallae.kotlin.beans.Person

// 扩展函数 + 局部函数
fun Person.insertPerson(person: Person) {
    fun validate(value: String) {
        if (value.isNullOrEmpty()) {
            throw IllegalArgumentException("$person" + ", $value" + "is not validate")
        }
    }

    validate(person.name)
    validate(person.age.toString())

    // insert person
}
