package com.example.macy.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.macy.R
import com.example.macy.data.local.AppDatabase
import com.example.macy.data.model.User
import com.example.macy.data.repository.UserRepository
import com.example.macy.databinding.FragmentSignInBinding

// SignInFragment.kt
class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.btnSignIn.setOnClickListener {
            val email = binding.etEmail.toString()
            val password = binding.etPassword.toString()
            viewModel.signIn(email, password)
        }

        viewModel.signInResult.observe(viewLifecycleOwner) { user: User? ->
            if (user != null) {
                findNavController().navigate(R.id.action_signIn_to_home)
            } else {
                Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_signIn_to_signUp)
        }
    }
}