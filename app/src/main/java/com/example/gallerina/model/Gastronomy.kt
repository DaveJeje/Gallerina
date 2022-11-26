package com.example.gallerina.model

import java.sql.Timestamp


data class Gastronomy (
    var eventname:String,
    var type:String,
    var description:String,
    var date:Timestamp,
    var budget: Int,
    var venue:String,
    var url: String

)