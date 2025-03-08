package com.example.macy.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macy.data.repository.UserRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: UserRepository) : ViewModel() {
    fun loadUserProfile(userId: Long) {
        viewModelScope.launch {
            repository.getUserById(userId)
        }
    }
}