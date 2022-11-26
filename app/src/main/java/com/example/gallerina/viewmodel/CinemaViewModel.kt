package com.example.gallerina.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallerina.domain.Repository
import com.example.gallerina.model.Cinema

class CinemaViewModel: ViewModel() {
    val repository=Repository()
    fun fetchCinemaData(): LiveData<MutableList<Cinema>>{
        val mutableLiveData=MutableLiveData<MutableList<Cinema>>()
        repository.getCinemaData().observeForever{
            mutableLiveData.value=it
        }
        return mutableLiveData
    }


}