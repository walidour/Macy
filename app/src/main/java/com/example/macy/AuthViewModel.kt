package com.example.macy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: UserRepository) : ViewModel() {
    private val _signInResult = MutableLiveData<User?>()
    val signInResult: LiveData<User?> = _signInResult

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            val user = repository.signIn(email, password.hashWithSHA256())
            _signInResult.postValue(user)
        }
    }

    // Similarly for sign-up:
    fun signUp(name: String, email: String, password: String) {
        val hashedPassword = password.hashWithSHA256()
        val user = User(name = name, email = email, passwordHash = hashedPassword, address = "")
        viewModelScope.launch {
            repository.signUp(user)
        }
    }

}