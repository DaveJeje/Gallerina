package com.example.gallerina.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gallerina.model.Cinema
import com.example.gallerina.model.Faves
import com.google.firebase.firestore.FirebaseFirestore

class Repository {
    fun getCinemaData(): LiveData<MutableList<Cinema>>{
        val mutableLiveData=MutableLiveData<MutableList<Cinema>>()
        FirebaseFirestore.getInstance().collection("Cinema")
            .get().addOnSuccessListener {
            result->
            val cinemaList= mutableListOf<Cinema>()
            for (Movie in result){
                val title=Movie.getString("title")
                val genre=Movie.getString("genre")
                val description=Movie.getString("description")
                val venue=Movie.getString("venue")
                val date=Movie.getString("date")
                val price=Movie.getString("price")
                val url=Movie.getString("imgurl")
                val movie= Cinema(title,genre,description,venue,date,price,url)
                cinemaList.add(movie)


            }
            mutableLiveData.value=cinemaList

        }
        return mutableLiveData
    }
    fun getFaveData(): LiveData<MutableList<Faves>>{
        val mutableLiveData=MutableLiveData<MutableList<Faves>>()
        FirebaseFirestore.getInstance().collection("Faves")
            .get().addOnSuccessListener {
                    result->
                val FavesList= mutableListOf<Faves>()
                for (Movie in result){
                    val title=Movie.getString("title")
                    val genre=Movie.getString("genre")
                    val description=Movie.getString("description")
                    val venue=Movie.getString("venue")
                    val date=Movie.getString("date")
                    val price=Movie.getString("price")
                    val url=Movie.getString("imgurl")
                    val movie= Faves(title,genre,description,venue,date,price,url)
                    FavesList.add(movie)


                }
                mutableLiveData.value=FavesList

            }
        return mutableLiveData
    }


}