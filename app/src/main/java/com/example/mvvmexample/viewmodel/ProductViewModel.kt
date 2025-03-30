package com.example.mvvmexample.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mvvmexample.NetworkManager
import com.example.mvvmexample.data.ProductApiService
import com.example.mvvmexample.data.ProductDatabase
import com.example.mvvmexample.data.ProductRepository
import com.example.mvvmexample.model.Product
import kotlinx.coroutines.flow.Flow

class ProductViewModel(application: Application): AndroidViewModel(application) {
    var networkManager = NetworkManager()

    private val productDao = ProductDatabase.getInstance(context = application.applicationContext)
        .productDao()
    private val apiService = ProductApiService(networkManager.httpClient)

    private val repository = ProductRepository(productDao, apiService)

    var products: LiveData<List<Product>> = repository.getProducts().asLiveData()

    suspend fun updateProducts() {
        repository.updateProducts()
    }
}