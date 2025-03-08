package com.example.macy.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController // Add this import
import com.example.macy.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {
    private lateinit var binding: FragmentEditProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        // Get current user ID (replace with actual logic)
        val userId = 1L


        binding.btnSave.setOnClickListener {
            val name = binding.etName.toString() // Use binding!
            val email = binding.etEmail.toString()
            val address = binding.etAddress.toString()

            // Example: Update user (replace with actual user ID)
            viewModel.updateUser(userId = 1L, name, email, address)
            findNavController().navigateUp()
        }
    }
}