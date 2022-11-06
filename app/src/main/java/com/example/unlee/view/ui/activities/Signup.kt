package com.example.unlee.view.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.unlee.R

class Signup:AppCompatActivity() {
    lateinit var butregister:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        butregister=findViewById(R.id.but_registrarse)
        butregister.setOnClickListener{
            startActivity(Intent(this,Login::class.java))
        }
    }
}