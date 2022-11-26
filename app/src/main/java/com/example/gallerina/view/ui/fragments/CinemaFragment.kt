package com.example.gallerina.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gallerina.R
import com.example.gallerina.model.Cinema
import com.example.gallerina.view.adapter.CinemaAdapter
import com.example.gallerina.view.adapter.OnMovieItemClickListener
import com.example.gallerina.viewmodel.CinemaViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator


class CinemaFragment : Fragment(), OnMovieItemClickListener {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var recyclerCinema: RecyclerView
    lateinit var adapter:CinemaAdapter
    val viewmodel by lazy { ViewModelProvider(this).get(CinemaViewModel::class.java) }
    val database: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_cinema, container, false)
        recyclerCinema=view.findViewById(R.id.rvCinema)
        adapter= CinemaAdapter(requireContext(),this)
        recyclerCinema.adapter=adapter
        recyclerCinema.layoutManager=LinearLayoutManager(context)
        recyclerCinema.itemAnimator = SlideInUpAnimator()
        bottomNavigationView=view.findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener{item ->
            when(item.itemId){
                R.id.nav_home-> findNavController().navigate(R.id.action_cinemaFragment_to_menuFragment)

                R.id.nav_fav-> findNavController().navigate(R.id.action_cinemaFragment_to_faveFragment)

                R.id.nav_venue-> findNavController().navigate(R.id.action_cinemaFragment_to_venuesFragment)

                //R.id.nav_settings-> replaceFragment()



                else->{}

            }


            true

        }






        observeData()
        return view

    }



    private fun observeData(){
        viewmodel.fetchCinemaData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }



    override fun onItemClickMovie(movie: Cinema, position:Int){
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
        findNavController().navigate(R.id.action_cinemaFragment_to_detailsScreenFragment,bundle)
        val cardMuseum= view?.findViewById<CardView>(R.id.fragVenues)
        cardMuseum?.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_venuesFragment)
        }
    }

    override fun onItemClickFavorite(movie:Cinema) {


    }


}