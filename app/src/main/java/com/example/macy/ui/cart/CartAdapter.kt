// File: ui/cart/CartAdapter.kt
package com.example.macy.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.macy.data.model.CartItemWithProduct
import com.example.macy.databinding.ItemCartBinding

class CartAdapter(
    private var items: List<CartItemWithProduct>,
    private val onItemClick: (CartItemWithProduct) -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvProductName.text = item.product?.name
        holder.binding.tvQuantity.text = "Qty: ${item.cartItem.quantity}"
        holder.binding.btnRemove.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount() = items.size

    fun updateItems(newItems: List<CartItemWithProduct>) {
        items = newItems
        notifyDataSetChanged()
    }
}