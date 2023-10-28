package com.app.furnitureworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btn_login.setOnClickListener {
            startActivity(Intent(this@SignInActivity,DashboardActivity::class.java))
        }
        tv_sign_up.setOnClickListener {
            startActivity(Intent(this@SignInActivity,SignUpActivity::class.java))
        }
    }
}