package com.williamwallae.kotlin.delegates.NotNull

import java.lang.IllegalArgumentException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T>{
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalArgumentException("${value} + 'is null'")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value else throw IllegalArgumentException("${value} +'already init'+")
    }

}