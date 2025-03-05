package com.example.macy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val productId: Long = 0,
    val name: String,
    val category: String,
    val description: String,
    val price: Double,
    val imageUrl: String
)