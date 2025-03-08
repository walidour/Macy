package com.example.macy.ui.healthtips

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macy.data.repository.HealthTipRepository
import kotlinx.coroutines.launch

class HealthTipsViewModel(private val repository: HealthTipRepository) : ViewModel() {
    fun loadHealthTips() {
        viewModelScope.launch {
            repository.getAllTips()
        }
    }
}