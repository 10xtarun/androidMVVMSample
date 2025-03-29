package com.example.mvvmexample.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmexample.NetworkManager
import com.example.mvvmexample.viewmodel.ProductViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

@Composable
fun ProductView(productViewModel: ProductViewModel = viewModel()) {
    val productList by productViewModel.products
    val networkManager = NetworkManager()


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth()

        ) {
            Button(
                onClick = {
                    runBlocking(Dispatchers.IO) {
                        val result = networkManager.fetchProducts()
                        productViewModel.updateProducts(result)
                    }
                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Click!",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)

                )
            }
        }

        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(productList) { product ->
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillParentMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Column (
                            modifier = Modifier,
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = AbsoluteAlignment.Left
                        ) {
                                Text(
                                    text = product.title.toString(),
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    modifier = Modifier
                                        .padding(5.dp)
                                )

                                Text(
                                    text = product.description.toString(),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier
                                        .padding(5.dp)
                                )
                        }
                    }
                }

            }
        }
    }


}