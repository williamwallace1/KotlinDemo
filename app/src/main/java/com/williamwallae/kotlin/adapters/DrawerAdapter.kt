package com.williamwallae.kotlin.adapters

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.williamwallae.kotlin.R
import kotlinx.android.synthetic.main.view_drawer_item.view.*

/**
 * 侧边栏适配器
 */
class DrawerAdapter(private var items: List<String>, private var itemOnClickListener: MainItemOnClickListener)
    : RecyclerView.Adapter<DrawerAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItemStyle(items[position], itemOnClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val view = layoutInflater.inflate(R.layout.view_drawer_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {
        fun bindItemStyle(text: String, itemOnClickListener: MainItemOnClickListener) {
            view.setOnClickListener {
                itemOnClickListener.onItemClick(adapterPosition)
            }
            view.recycle_activity_rv_tv.text = text
            view.recycle_activity_rv_tv.textSize = 15f
            view.recycle_activity_rv_tv.setTextColor(Color.BLACK)
        }
    }
    interface MainItemOnClickListener {
        fun onItemClick(position: Int)
    }
}