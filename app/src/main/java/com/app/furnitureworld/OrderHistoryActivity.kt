package com.app.furnitureworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import com.app.furnitureworld.adaptors.OrderHistoryAdapter

import kotlinx.android.synthetic.main.activity_order_history.*

class OrderHistoryActivity : AppCompatActivity(), OrderHistoryAdapter.OrderHistoryListener {

    var list: MutableList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_history)



        rv_order_history.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL , false)
        val adapter = OrderHistoryAdapter(this@OrderHistoryActivity, list, this)
        rv_order_history.adapter = adapter
    }

    override fun onHistoryClick(pos: Int, action: String) {


    }

}