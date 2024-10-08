package com.example.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Next = findViewById<Button>(R.id.btnNext)
       val Back = findViewById<Button>(R.id.btnBack)

        Next.setOnClickListener {

            Toast.makeText(applicationContext,"Proceeding..",Toast.LENGTH_SHORT).show()
            intent= Intent(applicationContext,WelcomeActivity::class.java)
            startActivity(intent)
        }

        Back.setOnClickListener {
            finish()
        }
    }
}