package com.williamwallae.kotlin.views.activity

import android.app.Fragment
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.williamwallae.kotlin.R
import kotlinx.android.synthetic.main.fragment_pattern.view.*

/**
 * 范型
 */
class PatternFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val patternRootView = inflater!!.inflate(R.layout.fragment_pattern, container, false)

        // apply 可以避免创建 builder的方式来使用，因为对象调用的函数可以根据自己的需要来初始化自己，然后apply函数会返回它同一个对象
        val textView = patternRootView.textView.apply {
            text = "apply"
            setTextColor(Color.RED)
            textSize = 15f
        }

        return patternRootView
    }

}