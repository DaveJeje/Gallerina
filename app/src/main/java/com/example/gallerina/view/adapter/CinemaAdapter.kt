package com.example.gallerina.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gallerina.R
import com.example.gallerina.model.Cinema
import com.squareup.picasso.Picasso


class CinemaAdapter(val context: Context, var clickListener: OnMovieItemClickListener):RecyclerView.Adapter<CinemaAdapter.ViewHolder>() {
    var cinemaList= mutableListOf<Cinema>()
    fun setListData(data:MutableList<Cinema>){
        cinemaList=data
    }



    override fun onCreateViewHolder(ViewGroup: ViewGroup, position: Int): ViewHolder {
        val v=LayoutInflater.from(ViewGroup.context).inflate(R.layout.cardview_cinema,
        ViewGroup,false)
        return ViewHolder(v)


    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val movie=cinemaList[position]
        viewHolder.bin(movie, clickListener)
    }

    override fun getItemCount(): Int {
        return cinemaList.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bin(movie:Cinema, action:OnMovieItemClickListener){
            //Acá agregar ImageView con picasso o gliger

            Picasso.get().load(movie.url).into(itemView.findViewById<ImageView>(R.id.imgCinema))
            itemView.findViewById<TextView>(R.id.tvTitleCinema).text=movie.title
            itemView.findViewById<TextView>(R.id.tvGenreCinema).text = movie.genre
            itemView.findViewById<TextView>(R.id.tvDescriptionCinema).text = movie.description

            itemView.setOnClickListener{
                action.onItemClickMovie(movie,adapterPosition)
            }

        }
    }
}
interface OnMovieItemClickListener{
    fun onItemClickMovie(movie:Cinema, position: Int)
    fun onItemClickFavorite(movie:Cinema)
}