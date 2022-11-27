package com.example.gallerina.view.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gallerina.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Signup:AppCompatActivity() {
    lateinit var butregister:Button
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var name:EditText
    lateinit var email:EditText


    lateinit var dbReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        firebaseAuth = Firebase.auth
        dbReference=Firebase.database.reference.child("User")
        name = findViewById<EditText>(R.id.signupName)
        email = findViewById<EditText>(R.id.signupMail)
        val pass = findViewById<EditText>(R.id.signupPass)

        butregister=findViewById(R.id.but_registrarse)
        butregister.setOnClickListener{
            createUser(email.text.toString(), pass.text.toString(),
            name.text.toString())
        }
    }

    fun createUser(email:String,password:String,name:String){
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                Task-> if(Task.isSuccessful){
                    val user =firebaseAuth.currentUser
                    val db=dbReference.child(user?.uid.toString())
                    db.child("name").setValue(name)
                    db.child("email").setValue(email)

                    startActivity(Intent(this, Login::class.java))
            }else{
                Toast.makeText(baseContext,"Try again", Toast.LENGTH_LONG).show()
            }
            }


    }
}