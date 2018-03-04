package com.williamwallae.kotlin.delegates.preference

import android.content.Context

object DelegatePreference {
    fun <T : Any> preference(context: Context, name: String, value: String, default: T)
            = Preference(context, name, value, default)
}