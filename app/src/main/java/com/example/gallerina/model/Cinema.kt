package com.example.gallerina.model

import java.sql.Timestamp


class Cinema: java.io.Serializable {
    lateinit var title:String
    lateinit var genre:String
    lateinit var description:String
    lateinit var date:Timestamp
    lateinit var price: Number
    lateinit var venue:String

}