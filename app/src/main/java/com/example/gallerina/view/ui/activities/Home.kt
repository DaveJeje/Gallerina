package com.example.gallerina.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import com.example.gallerina.R
import com.example.gallerina.databinding.ActivityHomeBinding
import com.example.gallerina.view.ui.fragments.FaveFragment
import com.example.gallerina.view.ui.fragments.MenuFragment
import com.example.gallerina.view.ui.fragments.VenuesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class Home : AppCompatActivity() {



    private lateinit var bottomNavigationView: BottomNavigationView
    lateinit var binding:ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding=ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_home)

    }






fun replaceFragment (fragment: Fragment) {
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.homelayout, fragment)
    fragmentTransaction.commit()
}
}





