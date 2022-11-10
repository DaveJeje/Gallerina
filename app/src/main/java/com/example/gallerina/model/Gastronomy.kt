package com.example.gallerina.model

import java.sql.Timestamp


class Gastronomy: java.io.Serializable {
    lateinit var eventname:String
    lateinit var type:String
    lateinit var description:String
    lateinit var date:Timestamp
    lateinit var budget: Number
    lateinit var venue:String

}