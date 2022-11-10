package com.example.gallerina.view.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.gallerina.R
import com.example.gallerina.databinding.ActivityMainBinding

class Lander:AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var signupbutton: Button
    lateinit var loginbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding=ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_lander)
        signupbutton= findViewById(R.id.sign_button2)
        loginbutton=findViewById(R.id.login_button2)

        signupbutton.setOnClickListener{
            startActivity(Intent(this,Signup::class.java))
        }
        loginbutton.setOnClickListener{
            startActivity(Intent(this,Login::class.java))
        }
    }


}
