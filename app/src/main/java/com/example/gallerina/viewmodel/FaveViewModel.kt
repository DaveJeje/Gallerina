package com.example.gallerina.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallerina.domain.Repository
import com.example.gallerina.model.Faves

class FaveViewModel: ViewModel() {
    val repository= Repository()

    fun fetchFaveData(): LiveData<MutableList<Faves>> {
        val mutableLiveData= MutableLiveData<MutableList<Faves>>()
        repository.getFaveData().observeForever{
            mutableLiveData.value=it
        }
        return mutableLiveData
    }


}