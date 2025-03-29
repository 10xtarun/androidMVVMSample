package com.example.mvvmexample

import com.example.mvvmexample.model.Product
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class NetworkManager {
    val httpClient = HttpClient(CIO)

    suspend fun fetchProducts(): List<Product> {
        val response = httpClient.get(urlString = "https://fakestoreapi.com/products")

        val productList = Json.decodeFromString<List<Product>>(response.bodyAsText())

        return productList
    }
}