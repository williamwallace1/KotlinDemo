package com.williamwallae.kotlin.domain

import android.content.Context

/**
 * 范型
 */
class TypedClass<out T: Context>(parameter: T) {
    val value: T = parameter
}