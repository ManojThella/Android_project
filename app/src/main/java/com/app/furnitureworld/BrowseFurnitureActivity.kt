package com.app.furnitureworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.furnitureworld.adaptors.BrowseItemsAdapter
import kotlinx.android.synthetic.main.activity_browse_items.*

class BrowseFurnitureActivity : AppCompatActivity(), BrowseItemsAdapter.BrowseListener {

    var list: MutableList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse_items)



        rv_browse_items.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL , false)
        val adapter = BrowseItemsAdapter(this@BrowseFurnitureActivity, list, this)
        rv_browse_items.adapter = adapter
    }

    override fun onBrowseClick(pos: Int, action: String) {

    }
}