package com.example.gallerina.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.gallerina.R
import com.example.gallerina.model.Cinema
import com.example.gallerina.view.adapter.OnMovieItemClickListener
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

class DetailsScreenFragment : DialogFragment(), OnMovieItemClickListener {
    val database: FirebaseFirestore=FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details_screen, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val poster = arguments?.getString("url")
        val title= arguments?.getString("title")
        val description= arguments?.getString("description")
        val genre= arguments?.getString("genre")
        val venue=arguments?.getString("venue")
        val date=arguments?.getString("date")
        val price=arguments?.getString("price")

        Picasso.get().load(poster).into(view.findViewById<ImageView>(R.id.imgCinema))
        view.findViewById<TextView>(R.id.tvTitleCinema).text=title
        view.findViewById<TextView>(R.id.tvGenreCinema).text=genre
        view.findViewById<TextView>(R.id.tvVenue).text=venue
        view.findViewById<TextView>(R.id.tvDescriptionCinema).text=description
        view.findViewById<TextView>(R.id.tvPriceCinema).text=price
        view.findViewById<TextView>(R.id.tvDateCinema).text=date
        val FaveButton=view.findViewById<Button>(R.id.FaveButton)
        val movie=Cinema(title,genre,description,venue,date,price,poster)
        FaveButton.setOnClickListener{
            onItemClickFavorite(movie)
        }


    }

    override fun onItemClickMovie(movie: Cinema, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onItemClickFavorite(movie:Cinema) {
        val title:String?=movie.title
        val genre:String?=movie.genre
        val description:String?=movie.description
        val venue:String?=movie.venue
        val date: String?=movie.date
        val price: String?=movie.price
        val url: String?=movie.url
        val data= hashMapOf(
            "title" to title,
            "genre" to genre,
            "description" to description,
            "venue" to venue,
            "date" to date,
            "price" to price,
            "imgurl" to url)
        database.collection("Faves")
            .document(title.toString())
            .set(data)
            .addOnSuccessListener {
                Toast.makeText(context, "Added to the Faves", Toast.LENGTH_SHORT).show()
            }

    }}
