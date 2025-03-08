package com.example.macy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartItem(
    @PrimaryKey(autoGenerate = true) val cartItemId: Long = 0,
    val userId: Long,
    val productId: Long,
    val quantity: Int
)