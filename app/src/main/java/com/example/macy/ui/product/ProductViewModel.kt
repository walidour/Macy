package com.example.macy.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macy.data.model.Product
import com.example.macy.data.repository.ProductRepository
import kotlinx.coroutines.launch

// File: ui/product/ProductViewModel.kt
class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    private val _product = MutableLiveData<Product?>()
    val product: LiveData<Product?> = _product

    fun getProductById(productId: Long) {
        viewModelScope.launch {
            _product.value = repository.getProductById(productId)
        }
    }
}