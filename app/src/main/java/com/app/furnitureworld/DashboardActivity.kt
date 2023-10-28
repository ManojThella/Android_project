package com.app.furnitureworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btn_post_furniture.setOnClickListener {
            startActivity(Intent(this@DashboardActivity,PostFurnitureActivity::class.java))
        }

        btn_browse_items.setOnClickListener {
            startActivity(Intent(this@DashboardActivity,BrowseFurnitureActivity::class.java))
        }

//        btn_history.setOnClickListener {
//            startActivity(Intent(this@DashboardActivity,OrderHistoryActivity::class.java))
//        }

        btn_profile.setOnClickListener {
            startActivity(Intent(this@DashboardActivity,ProfileActivity::class.java))
        }
    }
}