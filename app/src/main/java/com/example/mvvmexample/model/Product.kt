package com.example.mvvmexample.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Product (
    @SerialName("id"          ) var id          : Int?    = null,
    @SerialName("title"       ) var title       : String? = null,
    @SerialName("price"       ) var price       : Double? = null,
    @SerialName("description" ) var description : String? = null,
    @SerialName("category"    ) var category    : String? = null,
    @SerialName("image"       ) var image       : String? = null,
    @SerialName("rating"      ) var rating      : ProductRating? = ProductRating()
)

@Serializable
data class ProductRating (
    @SerialName("rate"  ) var rate  : Double? = null,
    @SerialName("count" ) var count : Int?    = null
)