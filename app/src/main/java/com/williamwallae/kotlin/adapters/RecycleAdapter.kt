package com.williamwallae.kotlin.adapters

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.williamwallae.kotlin.R
import com.williamwallae.kotlin.beans.EntityBean

class RecycleAdapter(private var entityList: List<EntityBean.Entity>) : RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: RecycleAdapter.ViewHolder?, position: Int) {
        holder?.bindItemStyle(entityList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecycleAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val view = layoutInflater.inflate(R.layout.fragment_recycle_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = entityList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val mRecycleTv: TextView

        init {
            mRecycleTv = view.findViewById(R.id.recycle_activity_rv_tv)
        }

        fun bindItemStyle(entityBean: EntityBean.Entity) {
            if (mRecycleTv is ImageView) mRecycleTv.setImageResource(R.drawable.ic_launcher_background)
            mRecycleTv.text = ("${entityBean.field_name} + ${entityBean.field_desc}")
            mRecycleTv.textSize = 15f
            mRecycleTv.setTextColor(Color.BLACK)
        }
    }
}