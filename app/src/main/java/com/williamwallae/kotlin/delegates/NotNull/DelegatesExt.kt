package com.williamwallae.kotlin.delegates.NotNull

import kotlin.properties.ReadWriteProperty

object DelegatesExt {
    fun <T : kotlin.Any> notNullSingleValue(): ReadWriteProperty<kotlin.Any?, T> = NotNullSingleValueVar()
}