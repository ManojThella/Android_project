package com.app.furnitureworld.adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.app.furnitureworld.R


class BrowseItemsAdapter(private val context : Context,
                         private val list: List<String>,
                         private val listener: BrowseListener) : RecyclerView.Adapter<BrowseItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_browse_items , parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    }

    override fun getItemCount(): Int {
        return 2
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_image: ImageView


        init {
            iv_image = itemView.findViewById(R.id.iv_image)
//            ll_item = itemView.findViewById(R.id.ll_item)
//            tv_menu_name = itemView.findViewById(R.id.tv_menu_name)

        }
    }

    interface BrowseListener {
        fun onBrowseClick(pos: Int, action: String)
    }
}