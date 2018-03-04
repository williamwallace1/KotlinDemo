package com.williamwallae.kotlin.beans

// 主构造函数
class Dog(val dogColor: Int, val dogFood: String): Animal(dogColor) {
    // 次构造函数
    constructor(dogColor: Int, dogFood: String, dogSleep: Int) : this(dogColor, dogFood)
    var footNum = 4
    companion object {
        var eyeNum = 0
    }

    // 只有设为inner 才可以访问外部的变量 才能当成正常的内部类
    inner class Foot(val num: Int) {
        init {
            footNum = 2
            eyeNum = 3
        }
    }
}