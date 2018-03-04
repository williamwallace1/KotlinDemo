package com.williamwallae.kotlin.views.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.williamwallae.kotlin.R

/**
 * 编辑页面
 */
class EditActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
    }

}