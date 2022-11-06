package com.example.unlee.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper.myLooper
import com.example.unlee.R
import com.example.unlee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Las siguientes son para asociar la activity al layout (como el sentContentVie(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configuración para correr la animación enel layout activity main
        binding.animationView.setAnimation(R.raw.animation)
        binding.animationView.playAnimation()

        //configuración para que la transición entre la animación y la  siguiente activity se
        //realice tras 4seg
        handler=Handler(myLooper()!!)
        handler.postDelayed({
            val intent=Intent(this, Lander::class.java)
            startActivity(intent)
            finish()
        },4000)
        }


    }



