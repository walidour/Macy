package com.example.macy.ui.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macy.data.repository.OrderRepository
import kotlinx.coroutines.launch

class OrderViewModel(private val repository: OrderRepository) : ViewModel() {
    fun getOrderById(orderId: Long) {
        viewModelScope.launch {
            repository.getOrderById(orderId)
        }
    }
}