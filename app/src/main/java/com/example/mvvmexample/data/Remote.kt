package com.example.mvvmexample.data

import com.example.mvvmexample.model.Product
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class ProductApiService(private val httpClient: HttpClient) {
    private val BASE_URL = "https://fakestoreapi.com/products"

    suspend fun getProducts(): List<Product> {
        val response = httpClient.get(urlString = BASE_URL)

        val productList = Json { ignoreUnknownKeys = true }
            .decodeFromString<List<Product>>(response.bodyAsText())

        return productList
    }
}