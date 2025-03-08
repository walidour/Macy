package com.example.macy.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.macy.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel
    private lateinit var adapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        adapter = CartAdapter(emptyList()) { item ->
            // Handle item removal
        }

        binding.rvCartItems.adapter = adapter
        binding.rvCartItems.layoutManager = LinearLayoutManager(context)

        viewModel.cartItems.observe(viewLifecycleOwner) { items ->
            adapter.updateItems(items)
            binding.tvTotalPrice.text = "$${viewModel.calculateTotal()}"
        }
    }
}