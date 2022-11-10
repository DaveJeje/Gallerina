package com.example.gallerina.view.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gallerina.R
import com.example.gallerina.R.id.sign_button
import com.example.gallerina.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login: AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var signupbutton: Button
    lateinit var loginbutton: Button
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding=ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_login)
        firebaseAuth= Firebase.auth
        val email=findViewById<EditText>(R.id.login_username_field)
        val pass=findViewById<EditText>(R.id.login_pass_field)

        signupbutton= findViewById(sign_button)
        loginbutton=findViewById(R.id.login_button)

        signupbutton.setOnClickListener{
            startActivity(Intent(this,Signup::class.java))
        }
        loginbutton.setOnClickListener{
            login(email.text.toString(),pass.text.toString())
        }

        val txtRecover=findViewById<TextView>(R.id.recoverpasstext)
        txtRecover.setOnClickListener{
            startActivity(Intent(this,Forgotpass::class.java))
        }
    }

    fun login(email:String,pass:String){
        firebaseAuth.signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener(this){
                Task-> if (Task.isSuccessful){
                    startActivity(Intent(this,Home::class.java))
            }
                else{
                    Toast.makeText(baseContext,"try again", Toast.LENGTH_SHORT).show()
            }
            }

    }


}