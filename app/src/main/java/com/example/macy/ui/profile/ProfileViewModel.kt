package com.example.macy.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macy.data.model.User
import com.example.macy.data.repository.UserRepository
import kotlinx.coroutines.launch

// Add updateUser() method
class ProfileViewModel(private val repository: UserRepository) : ViewModel() {
    fun updateUser(userId: Long, name: String, email: String, address: String) {
        viewModelScope.launch {
            val updatedUser = User(
                userId = userId,
                name = name,
                email = email,
                passwordHash = "", // Preserve existing password hash
                address = address
            )
            repository.updateUser(updatedUser)
        }
    }
}