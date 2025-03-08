package com.example.macy.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macy.data.repository.ProductRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: ProductRepository) : ViewModel() {
    fun loadTrendingProducts() {
        viewModelScope.launch {
            val products = repository.getAllProducts()
            // Update UI via LiveData/StateFlow
        }
    }
}