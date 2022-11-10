package com.example.gallerina.network


import com.example.gallerina.model.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

const val CINEMA_COLLECTION_NAME="Cinema"
const val GASTRONOMY_COLLECTION_NAME="Gastronomy"
const val USER_COLLECTION_NAME="User"


class FireStoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    fun getCinema(callBack: CallBack<List<Cinema>>){
        firebaseFirestore.collection(CINEMA_COLLECTION_NAME)
            .get()
            .addOnSuccessListener {
                result -> for (movie in result){
                    val list =result.toObjects(Cinema::class.java)
                    callBack.onSuccess(list)
                    break
                }
            }
    }

}