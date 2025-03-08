package com.example.macy.data.repository


import com.example.macy.data.local.OrderDao
import com.example.macy.data.model.Order

class OrderRepository(private val orderDao: OrderDao) {
    suspend fun insert(order: Order) = orderDao.insert(order)
    suspend fun getOrdersByUserId(userId: Long): List<Order> = orderDao.getOrdersByUserId(userId)
    suspend fun getOrderById(orderId: Long): Order? = orderDao.getOrderById(orderId)
}