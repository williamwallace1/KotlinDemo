package com.williamwallae.kotlin.views.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.williamwallae.kotlin.R
import com.williamwallae.kotlin.adapters.DrawerAdapter
import com.williamwallae.kotlin.adapters.DrawerAdapter.MainItemOnClickListener
import com.williamwallae.kotlin.factory.getFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val items = listOf("RecycleView", "操作符", "FlowControlRang", "Pattern范型", "Anko")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        left_drawer.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        left_drawer.adapter = DrawerAdapter(items, object : MainItemOnClickListener {
            override fun onItemClick(position: Int) {
                setContentFragment(position)
            }
        })
        floatButton.setOnClickListener { this@MainActivity.startActivity(Intent(this@MainActivity, EditActivity::class.java)) }
        setContentFragment(0)
    }

    private fun setContentFragment(position: Int) {
        getFragment(position)?.let {
            val fragmentManager = fragmentManager
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, it)
                    .commit()

            title = items[position]
            drawer_layout.closeDrawer(left_drawer)
        }
    }

}

