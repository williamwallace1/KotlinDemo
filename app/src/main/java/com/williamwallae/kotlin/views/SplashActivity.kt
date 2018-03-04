package com.williamwallae.kotlin.views

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.williamwallae.kotlin.R
import com.williamwallae.kotlin.views.activity.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    val TAG = SplashActivity::class.simpleName
    private val REQUEST_PHONE_PERMISSION_ACCESS_NETWORK_STATE = 1000
    private val REQUEST_PHONE_PERMISSION_INTERNET = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED -> {
                Log.d(TAG, "ACCESS_NETWORK_STATE no permission")
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_NETWORK_STATE), REQUEST_PHONE_PERMISSION_ACCESS_NETWORK_STATE)
            }
            ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED -> {
                Log.d(TAG, "INTERNET no permission")
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET), REQUEST_PHONE_PERMISSION_INTERNET)
            }
            else -> {
                Log.d(TAG, "has permission")
                jumpMainActivity()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            when (requestCode) {
                REQUEST_PHONE_PERMISSION_ACCESS_NETWORK_STATE -> jumpMainActivity()
                REQUEST_PHONE_PERMISSION_INTERNET -> jumpMainActivity()
            }
        }
    }

    fun jumpMainActivity() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            val countDownTimer = object : CountDownTimer(3000L, 1000L) {
                override fun onFinish() {
                    this@SplashActivity.startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }

                override fun onTick(p0: Long) {
                    timer.text = (p0/1000).toString()
                }
            }
            countDownTimer.start()
        }
    }
}