package com.example.mvvmexample.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Entity(tableName = "products")
@Serializable
data class Product (
    @PrimaryKey
    @SerialName("id"          )
    var id          : Int?    = null,

    @SerialName("title"       )
    var title       : String? = null,

    @SerialName("price"       )
    var price       : Double? = null,

    @SerialName("description" )
    var description : String? = null,

    @SerialName("category"    )
    var category    : String? = null,

    @SerialName("image"       )
    var image       : String? = null,

//    @SerialName("rating"      )
//    var rating      : ProductRating? = ProductRating()
)
//
//@Serializable
//data class ProductRating (
//    @SerialName("rate"  )
//    var rate  : Double? = null,
//    @SerialName("count" )
//    var count : Int?    = null
//)