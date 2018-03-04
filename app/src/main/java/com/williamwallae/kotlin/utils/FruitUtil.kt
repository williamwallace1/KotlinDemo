package com.williamwallae.kotlin.utils

import com.williamwallae.kotlin.beans.Fruit

/**
 * 生成 fruit 单例对象
 */
fun getFruitNum(fruit: Fruit): Int = when (fruit) {
    is Fruit.Apple -> 1
    is Fruit.Banana -> 2
    is Fruit.Other -> 3
// 不需要再写 else，因为密封类已经全部覆盖
}