package com.example.macy.data.repository

import com.example.macy.data.local.OrderDao
import com.example.macy.data.model.Order
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Date

class OrderRepository(private val orderDao: OrderDao) {

    // Create a new order from cart items
    suspend fun createOrder(
        userId: Long,
        productIds: List<Long>,
        totalPrice: Double
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val newOrder = Order(
                    userId = userId,
                    productList = productIds,
                    totalPrice = totalPrice,
                    status = "Processing",
                    timestamp = Date().time
                )
                orderDao.insert(newOrder)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    // Get all orders for a user
    suspend fun getOrdersByUserId(userId: Long): List<Order> {
        return orderDao.getOrdersByUserId(userId)
    }

    // Get specific order details
    suspend fun getOrderById(orderId: Long): Order? {
        return orderDao.getOrderById(orderId)
    }

    // Update order status
    suspend fun updateOrderStatus(orderId: Long, newStatus: String) {
        orderDao.getOrderById(orderId)?.let { order ->
            val updatedOrder = order.copy(status = newStatus)
            orderDao.update(updatedOrder)
        }
    }
}