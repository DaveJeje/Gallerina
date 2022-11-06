package com.example.unlee.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.unlee.R

class forgotpass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpass)

        val btnRecover=findViewById<Button>(R.id.recoverpass)
        btnRecover.setOnClickListener{
            startActivity(Intent(this,Login::class.java))

        }
    }
}