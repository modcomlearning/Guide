package com.lit.guide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        val next2 = findViewById<TextView>(R.id.next2)
        next2.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }
}