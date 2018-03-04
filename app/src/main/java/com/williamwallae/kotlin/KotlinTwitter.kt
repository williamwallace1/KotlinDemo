package com.williamwallae.kotlin

import android.app.Application

class KotlinTwitter : Application() {
    private lateinit var instance: KotlinTwitter

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}