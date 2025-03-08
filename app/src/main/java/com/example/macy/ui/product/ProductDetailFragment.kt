package com.example.macy.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.macy.databinding.FragmentProductDetailBinding

class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        val productId = arguments?.getLong("productId") ?: 0L

        viewModel.product.observe(viewLifecycleOwner) { product ->
            product?.let {
                binding.tvProductName.text = it.name
                binding.tvPrice.text = "$${it.price}"
                Glide.with(this).load(it.imageUrl).into(binding.ivProductImage)
            }
        }

        viewModel.getProductById(productId)
    }
}