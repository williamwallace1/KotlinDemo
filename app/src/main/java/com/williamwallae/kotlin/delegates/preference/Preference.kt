package com.williamwallae.kotlin.delegates.preference

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Preference<T>(context: Context, val name: String, val value: String, val default: T) : ReadWriteProperty<Any?, T> {

    val prefs by lazy {
        context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getPreferences(name, default)
    }

    private fun <T> getPreferences(name: String, default: T): T = with(prefs) {
        val res: Any = when (default) {
            is Int -> getInt(name, default)
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Float -> getFloat(name, default)
            is Boolean -> getBoolean(name, default)
            else -> {
                throw IllegalArgumentException("$default is not support")
            }
        }
        res as T
    }


    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    private fun <T> putPreference(name: String, value: T) {
        prefs.edit().apply {
            when (value) {
                is Int -> putInt(name, value)
                is Long -> putLong(name, value)
                is String -> putString(name, value)
                is Float -> putFloat(name, value)
                is Boolean -> putBoolean(name, value)
                else -> {
                    throw IllegalArgumentException("$value is not support")
                }
            }
        }.apply()
    }

}