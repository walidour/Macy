package com.example.macy.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macy.data.model.User
import com.example.macy.data.repository.UserRepository
import com.example.macy.utils.hashWithSHA256
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: UserRepository) : ViewModel() {
    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            val user = repository.signIn(email, password.hashWithSHA256())
            // Handle result in Fragment via LiveData
        }
    }

    fun signUp(name: String, email: String, password: String) {
        viewModelScope.launch {
            val hashedPassword = password.hashWithSHA256()
            repository.signUp(User(name = name, email = email, passwordHash = hashedPassword, address = ""))
        }
    }
}