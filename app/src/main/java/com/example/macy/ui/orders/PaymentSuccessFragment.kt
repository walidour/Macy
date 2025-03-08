package com.example.macy.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.macy.R // Add this import
import com.example.macy.databinding.FragmentPaymentSuccessBinding

class PaymentSuccessFragment : Fragment() {
    private lateinit var binding: FragmentPaymentSuccessBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPaymentSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBackToHome.setOnClickListener {
            // Ensure this action exists in nav_graph.xml
            findNavController().navigate(R.id.action_paymentSuccess_to_home)
        }
    }
}