package com.example.gallerina.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.gallerina.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Forgotpass : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpass)

        firebaseAuth = Firebase.auth

        val email =findViewById<EditText>(R.id.recover_email)


        val btnRecover=findViewById<Button>(R.id.recoverpass)
        btnRecover.setOnClickListener{
            restorePassword(email.text.toString())

        }
    }

    fun restorePassword(email:String){
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnCompleteListener(this){
                Task-> if (Task.isSuccessful){
                startActivity(Intent(this,Login::class.java))
            }else{
                Toast.makeText(this, "Restore Fail", Toast.LENGTH_LONG).show()
            }
            }
    }
}