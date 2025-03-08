package com.example.macy.ui.healthtips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.macy.databinding.FragmentHealthTipsBinding

class HealthTipsFragment : Fragment() {
    private lateinit var binding: FragmentHealthTipsBinding
    private lateinit var viewModel: HealthTipsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHealthTipsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HealthTipsViewModel::class.java)
        viewModel.loadHealthTips()
    }
}