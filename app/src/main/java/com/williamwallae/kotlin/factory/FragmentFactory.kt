package com.williamwallae.kotlin.factory

import android.app.Fragment
import android.util.SparseArray
import com.williamwallae.kotlin.KotlinTwitter
import com.williamwallae.kotlin.views.AnkoFragment
import com.williamwallae.kotlin.views.FlowControlRangFragment
import com.williamwallae.kotlin.views.MainFragment
import com.williamwallae.kotlin.views.OperatorsFragment
import com.williamwallae.kotlin.views.activity.PatternFragment

// 顶层属性
val fragmentSparsArray: SparseArray<android.app.Fragment> = SparseArray()
val absoluteFilePath = KotlinTwitter.instance?.externalCacheDir?.absoluteFile
// 顶层函数
fun getFragment(position: Int): Fragment? {
    if (fragmentSparsArray.get(position) != null) {
        return fragmentSparsArray.get(position)
    } else {
        return when (position) {
            0 -> MainFragment()
            1 -> OperatorsFragment()
            2 -> FlowControlRangFragment()
            3 -> PatternFragment()
            4 -> AnkoFragment()
            else -> null
        }
    }
}