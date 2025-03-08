package com.example.macy.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macy.data.repository.OrderRepository
import kotlinx.coroutines.launch

class OrderViewModel(private val repository: OrderRepository) : ViewModel() {
    private val _orderResult = MutableLiveData<Boolean>()
    val orderResult: LiveData<Boolean> = _orderResult

    fun createOrder() {
        viewModelScope.launch {
            try {
                // Replace with actual order creation logic
                val success = repository.createOrder() // Ensure repository has this method
                _orderResult.postValue(success)
            } catch (e: Exception) {
                _orderResult.postValue(false)
            }
        }
    }
}