package com.example.macy.data.repository

import com.example.macy.data.local.CartDao
import com.example.macy.data.local.ProductDao
import com.example.macy.data.model.CartItem
import com.example.macy.data.model.Product
import com.example.macy.data.model.CartItemWithProduct // Add this import

class CartRepository(
    private val cartDao: CartDao,
    private val productDao: ProductDao
) {
    suspend fun addToCart(userId: Long, productId: Long, quantity: Int) {
        cartDao.insert(CartItem(userId = userId, productId = productId, quantity = quantity))
    }

    suspend fun getCartItemsWithProducts(userId: Long): List<CartItemWithProduct> {
        val cartItems = cartDao.getCartItemsByUserId(userId)
        return cartItems.map { cartItem ->
            val product = productDao.getProductById(cartItem.productId)
            CartItemWithProduct(cartItem, product) // Now resolves
        }
    }
    // File: data/repository/CartRepository.kt
    suspend fun calculateCartTotal(userId: Long): Double {
        val items = getCartItemsWithProducts(userId)
        return items.sumOf { it.product?.price?.times(it.cartItem.quantity) ?: 0.0 }
    }
    suspend fun clearCart(userId: Long) {
        cartDao.clearCart(userId)
    }
}