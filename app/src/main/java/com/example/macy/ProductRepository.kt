package com.example.macy

class ProductRepository(private val productDao: ProductDao) {
    suspend fun getAllProducts() = productDao.getAllProducts()
    suspend fun getProductsByCategory(category: String) = productDao.getProductsByCategory(category)
    suspend fun getProductById(productId: Long) = productDao.getProductById(productId)
}