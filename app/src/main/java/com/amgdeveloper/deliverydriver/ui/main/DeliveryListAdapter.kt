package com.amgdeveloper.deliverydriver.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amgdeveloper.deliverydriver.databinding.DeliveryListItemBinding
import com.amgdeveloper.deliverydriver.domain.Delivery

/**
 * Created by amgdeveloper on 06/03/2021
 */
class DeliveryListAdapter(
    var deliveries: List<Delivery>,
    private val deliveryListener: (Delivery) -> Unit
) :
    RecyclerView.Adapter<DeliveryListAdapter.DeliveryViewHolder>() {

    class DeliveryViewHolder(private val binding: DeliveryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(delivery: Delivery) {
            binding.deliveryIdDescTv.text = delivery.id.toString()
            binding.addressTv.text = delivery.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
        val binding = DeliveryListItemBinding.inflate(
            LayoutInflater
                .from(parent.context), parent, false
        )
        return DeliveryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return deliveries.size
    }

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        holder.bind(deliveries[position])
        holder.itemView.setOnClickListener { deliveryListener(deliveries[position]) }
    }
}