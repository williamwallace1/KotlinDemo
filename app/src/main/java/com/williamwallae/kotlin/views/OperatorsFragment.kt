package com.williamwallae.kotlin.views

import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.williamwallae.kotlin.R
import com.williamwallae.kotlin.beans.Person
import com.williamwallae.kotlin.utils.getLastChar
import kotlinx.android.synthetic.main.fragment_operator.view.*

/**
 * 操作符
 */
class OperatorsFragment : Fragment() {

    val TAG = OperatorsFragment::class.simpleName
    private var a: String? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)

        val operatorRootView = inflater!!.inflate(R.layout.fragment_operator, container, false)
        operatorRootView.operatorTv.text = TAG

        val list = listOf(Person("xiaoming", 11), Person("xiaohuang", 18), Person("xiaoliu", 7))
        Log.d(TAG, list.reversed().toString())
        Log.d(TAG, list.sorted().toString())
        Log.d(TAG, list.sortedBy { it.name }.toString())
        Log.d(TAG, list.sortedDescending().toString())
        Log.d(TAG, list.sortedByDescending { it.age }.toString())

        val numberList = listOf(3, 2, 8)
        Log.d(TAG, (numberList.any { it % 2 == 0 }.toString()))
        Log.d(TAG, (numberList.all { it < 100 }.toString()))
        Log.d(TAG, numberList.count().toString())
        Log.d(TAG, (numberList.any { it < 100 }.toString()))

        val any = try {
            val test1 = a ?: 123
            val test2 = a ?: throw IllegalArgumentException()
            Log.d(TAG, test1.toString())
            Log.d(TAG, test2)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }

        // 扩展函数
        "xiaoming".getLastChar()

        return operatorRootView
    }
}