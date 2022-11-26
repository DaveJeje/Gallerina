package com.example.gallerina.view.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gallerina.R
import com.example.gallerina.model.Faves
import com.example.gallerina.view.adapter.FaveAdapter
import com.example.gallerina.view.adapter.OnFaveItemClickListener
import com.example.gallerina.viewmodel.FaveViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore


class FaveFragment : Fragment(), OnFaveItemClickListener {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var recyclerFaves: RecyclerView
    lateinit var adapter: FaveAdapter
    val viewmodel by lazy { ViewModelProvider(this).get(FaveViewModel::class.java) }
    val database: FirebaseFirestore =FirebaseFirestore.getInstance()

    @SuppressLint("MissingInflateId", "MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fave, container, false)
        recyclerFaves=view.findViewById(R.id.rvFavorites)
        adapter = FaveAdapter(requireContext(),this)
        recyclerFaves.layoutManager=LinearLayoutManager(context)
        recyclerFaves.adapter=adapter
        observeData()
        bottomNavigationView=view.findViewById(R.id.bottom_navigation)
        
        bottomNavigationView.setOnItemSelectedListener{item ->
            when(item.itemId){
                R.id.nav_home-> findNavController().navigate(R.id.action_faveFragment_to_menuFragment)

                R.id.nav_fav-> null

                R.id.nav_venue-> findNavController().navigate(R.id.action_faveFragment_to_venuesFragment)

                //R.id.nav_settings-> replaceFragment()



                else->{}

            }


            true

        }

        return view
    }

    private fun observeData(){
        viewmodel.fetchFaveData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
    override fun onItemClickMovie(movie: Faves, position:Int){
        val title:String?=movie.title
        val genre:String?=movie.genre
        val description:String?=movie.description
        val venue:String?=movie.venue
        val date: String?=movie.date
        val price: String?=movie.price
        val url: String?=movie.url
        val bundle= bundleOf(
            "title" to title,
            "genre" to genre,
            "description" to description,
            "venue" to venue,
            "date" to date,
            "price" to price,
            "url" to url,
        )
        findNavController().navigate(R.id.action_faveFragment_to_detailsScreenFragment,bundle)
    }

    //override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)
        //firebaseAuth=Firebase.auth
        //val name=view.findViewById<EditText>(R.id.nameProfile)
        //val user=firebaseAuth.currentUser
       // name.text=user.uid.plus()
        //val email =view.findViewById<EditText>(R.id.emailProfile)
        //email.text =user.email.toString()


    }


