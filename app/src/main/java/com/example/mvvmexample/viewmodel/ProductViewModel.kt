package com.example.mvvmexample.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.model.Product

class ProductViewModel: ViewModel() {
    var products = mutableStateOf<List<Product>>(emptyList())

    fun updateProducts(productList: List<Product>) {
        products.value = productList
    }
}