package com.example.mvvmexample.data

import com.example.mvvmexample.model.Product
import kotlinx.coroutines.flow.Flow

class ProductRepository(
    private val productDao: ProductDao,
    private val apiService: ProductApiService
) {

    fun getProducts(): Flow<List<Product>> {
        return productDao.getProducts()
    }

    suspend fun updateProducts() {
        val response = apiService.getProducts()
        response.forEach { prd ->
            productDao.insertProduct(product = prd)
        }
    }
}