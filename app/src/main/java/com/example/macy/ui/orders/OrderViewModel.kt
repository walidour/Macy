package com.example.macy.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macy.data.repository.OrderRepository
import kotlinx.coroutines.launch

// Updated OrderViewModel.kt
class OrderViewModel(private val repository: OrderRepository) : ViewModel() {
    private val _orderResult = MutableLiveData<Boolean>()
    val orderResult: LiveData<Boolean> = _orderResult

    // Add parameters to the method
    fun createOrder(userId: Long, productIds: List<Long>, totalPrice: Double) {
        viewModelScope.launch {
            val success = repository.createOrder(userId, productIds, totalPrice)
            _orderResult.postValue(success)
        }
    }
}