package com.example.mvvmexample.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmexample.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * from products")
    fun getProducts(): Flow<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)
}

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        private var INSTANCE: ProductDatabase? = null

        fun getInstance(context: android.content.Context): ProductDatabase {
            return if(INSTANCE == null) {
                Room.databaseBuilder(
                    context = context.applicationContext,
                    ProductDatabase::class.java,
                    "mvvm_product_database"
                ).build()

            } else {
                INSTANCE!!
            }
        }
    }
}
