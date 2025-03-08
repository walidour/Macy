package com.example.macy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true) val orderId: Long = 0,
    val userId: Long,
    val productList: List<Long>, // Use TypeConverter
    val totalPrice: Double,
    val status: String, // "Placed", "Shipped", etc.
    val timestamp: Long
)