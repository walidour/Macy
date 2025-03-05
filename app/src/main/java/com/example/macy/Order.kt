package com.example.macy

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true) val orderId: Long = 0,
    val userId: Long,
    val productList: List<Long>, // List of product IDs (use TypeConverter for Room)
    val totalPrice: Double,
    val status: String, // e.g., "Placed", "Delivered"
    val timestamp: Long
)