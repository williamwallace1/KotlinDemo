package com.williamwallae.kotlin.views

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.williamwallae.kotlin.R
import com.williamwallae.kotlin.utils.showToast
import kotlinx.android.synthetic.main.fragment_flow_control_rang.view.*

/**
 * 流程控制
 */
class FlowControlRangFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val flowControlRangRootView = inflater!!.inflate(R.layout.fragment_flow_control_rang, container, false)

        (0 until flowControlRangRootView.mRootViewFlow.childCount step 1)
                .map { flowControlRangRootView.mRootViewFlow.getChildAt(it) }
                .forEach {
                    when (it) {
                        is CheckBox -> showToast(it.isChecked.toString())
                        is TextView -> showToast(it.text.toString())
                        is ViewGroup -> showToast(it.childCount.toString())
                    }
                }

        for (index in 0..flowControlRangRootView.mRootViewFlow.childCount) {
            print(index)
        }
        return flowControlRangRootView
    }

}