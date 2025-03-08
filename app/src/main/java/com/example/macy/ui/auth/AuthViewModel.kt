package com.example.macy.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macy.data.model.User
import com.example.macy.data.repository.UserRepository
import com.example.macy.utils.hashWithSHA256
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: UserRepository) : ViewModel() {
    private val _signInResult = MutableLiveData<User?>() // Nullable to handle failures
    val signInResult: LiveData<User?> = _signInResult

    private val _signUpResult = MutableLiveData<Boolean>()
    val signUpResult: LiveData<Boolean> = _signUpResult

    // Sign in with email and password
    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                val user = repository.signIn(
                    email = email,
                    passwordHash = password.hashWithSHA256()
                )
                _signInResult.postValue(user)
            } catch (e: Exception) {
                _signInResult.postValue(null) // Indicate failure
            }
        }
    }

    // Create new user account
    fun signUp(name: String, email: String, password: String, address: String = "") {
        viewModelScope.launch {
            try {
                val newUser = User(
                    name = name,
                    email = email,
                    passwordHash = password.hashWithSHA256(),
                    address = address
                )
                repository.signUp(newUser)
                _signUpResult.postValue(true) // Success
            } catch (e: Exception) {
                _signUpResult.postValue(false) // Failure
            }
        }
    }
}