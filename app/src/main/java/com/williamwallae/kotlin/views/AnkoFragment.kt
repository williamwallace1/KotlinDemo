package com.williamwallae.kotlin.views

import android.app.Fragment
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.williamwallae.kotlin.R
import com.williamwallae.kotlin.utils.showToast
import org.jetbrains.anko.*

/**
 * Anko
 */
class AnkoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return UI {
            verticalLayout {
                val name = editText {
                    hint = "请输入用户名"
                    hintTextColor = Color.GRAY
                    textColor = Color.BLACK
                    padding = 10
                }
                val password = editText {
                    hint = "请输入密码"
                    hintTextColor = Color.GRAY
                    textColor = Color.BLACK
                    padding = 10
                }
                button {
                    text = "登陆"
                    backgroundResource = R.drawable.anko_login_bg
                    onClick {
                        if (name.text.isNullOrEmpty()) return@onClick
                        showToast("Hi, 您的用户名 ${name.text}，密码${password.text} 登陆成功")
                    }
                }
            }

        }.view
    }

}