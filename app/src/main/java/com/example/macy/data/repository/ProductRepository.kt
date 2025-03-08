package com.example.macy.data.repository

import com.example.macy.data.local.ProductDao
import com.example.macy.data.model.Product

class ProductRepository(private val productDao: ProductDao) {
    suspend fun getAllProducts(): List<Product> = productDao.getAllProducts()
    suspend fun getProductsByCategory(category: String): List<Product> = productDao.getProductsByCategory(category)
    suspend fun getProductById(productId: Long): Product? = productDao.getProductById(productId)
}