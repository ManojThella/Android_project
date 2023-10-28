package com.app.furnitureworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        tv_sign_in.setOnClickListener {
            startActivity(Intent(this@SignUpActivity,SignInActivity::class.java))
        }
    }
}