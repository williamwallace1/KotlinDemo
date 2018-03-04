package com.williamwallae.kotlin.utils

import android.widget.Toast
import com.williamwallae.kotlin.KotlinTwitter

fun showToast(text: String = "default", length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(KotlinTwitter.instance, text, length).show()
}