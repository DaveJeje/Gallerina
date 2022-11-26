package com.example.gallerina.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gallerina.R
import com.example.gallerina.model.Faves
import com.example.gallerina.view.ui.fragments.FaveFragment
import com.squareup.picasso.Picasso


class FaveAdapter(val context: Context, var clickListener: FaveFragment):
    RecyclerView.Adapter<FaveAdapter.ViewHolder>() {
    var FavesList= mutableListOf<Faves>()
    fun setListData(data:MutableList<Faves>){
        FavesList=data
    }



    override fun onCreateViewHolder(ViewGroup: ViewGroup, position: Int): ViewHolder {
        val v=LayoutInflater.from(ViewGroup.context).inflate(
            R.layout.cardview_faves,
        ViewGroup,false)
        return ViewHolder(v)


    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val movie=FavesList[position]
        viewHolder.bin(movie, clickListener)
    }

    override fun getItemCount(): Int {
        return FavesList.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bin(movie: Faves, action:OnFaveItemClickListener){
            //Acá agregar ImageView con picasso o gliger

            Picasso.get().load(movie.url).into(itemView.findViewById<ImageView>(R.id.imgCinema))
            itemView.findViewById<TextView>(R.id.tvTitleCinema).text=movie.title
            itemView.findViewById<TextView>(R.id.tvGenreCinema).text = movie.genre
            itemView.findViewById<TextView>(R.id.tvDescriptionCinema).text = movie.description
            itemView.findViewById<TextView>(R.id.tvVenue).text = movie.venue
            itemView.findViewById<TextView>(R.id.tvDateCinema).text = movie.date
            itemView.findViewById<TextView>(R.id.tvPriceCinema).text=movie.price

            itemView.setOnClickListener{
                action.onItemClickMovie(movie,adapterPosition)
            }

        }
    }


}
interface OnFaveItemClickListener{
    fun onItemClickMovie(movie: Faves, position: Int)

}