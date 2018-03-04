package com.williamwallae.kotlin.views

import android.app.Fragment
import android.os.Bundle
import android.os.Debug
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.williamwallae.kotlin.R
import com.williamwallae.kotlin.adapters.RecycleAdapter
import com.williamwallae.kotlin.beans.EntityBean
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.jetbrains.anko.runOnUiThread
import java.net.URL
import kotlin.concurrent.thread

/**
 * 首页
 */
class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mainRootView = inflater!!.inflate(R.layout.fragment_main, container, false)
        mainRootView.recycle_activity_rv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        thread {
            Debug.startMethodTracing()
            val url = "https://api.meitu.com/public/schema.json"
            val response = URL(url).readText()
            val entityBean = Gson().fromJson(response, EntityBean::class.java)
            runOnUiThread { recycle_activity_rv.adapter = RecycleAdapter(entityBean.msg) }
            Debug.stopMethodTracing()
        }
        return mainRootView
    }

}