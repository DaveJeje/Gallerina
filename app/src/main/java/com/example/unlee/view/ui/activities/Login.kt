package com.example.unlee.view.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.unlee.R
import com.example.unlee.R.id.sign_button
import com.example.unlee.databinding.ActivityMainBinding

class Login: AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var signupbutton: Button
    lateinit var loginbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding=ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_login)
        signupbutton= findViewById(sign_button)
        loginbutton=findViewById(R.id.login_button)

        signupbutton.setOnClickListener{
            startActivity(Intent(this,Signup::class.java))
        }
        loginbutton.setOnClickListener{
            startActivity(Intent(this,Home::class.java))
        }

        val txtRecover=findViewById<TextView>(R.id.recoverpasstext)
        txtRecover.setOnClickListener{
            startActivity(Intent(this,forgotpass::class.java))
        }
    }


}