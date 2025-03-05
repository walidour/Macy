package com.example.macy

class CartRepository(private val cartDao: CartDao, private val productDao: ProductDao) {
    suspend fun addToCart(userId: Long, productId: Long, quantity: Int) {
        cartDao.insert(CartItem(userId = userId, productId = productId, quantity = quantity))
    }

    suspend fun getCartItemsWithProducts(userId: Long): List<CartItemWithProduct> {
        val cartItems = cartDao.getCartItemsByUserId(userId)
        return cartItems.map { cartItem ->
            val product = productDao.getProductById(cartItem.productId)
            CartItemWithProduct(cartItem, product)
        }
    }
}

// Helper class to combine CartItem and Product
data class CartItemWithProduct(
    val cartItem: CartItem,
    val product: Product?
)