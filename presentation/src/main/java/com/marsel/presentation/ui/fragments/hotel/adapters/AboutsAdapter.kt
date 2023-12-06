package com.marsel.presentation.ui.fragments.hotel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.marsel.presentation.databinding.ItemAboutsHotelBinding

class AboutsAdapter(private val list: List<String>) :
    RecyclerView.Adapter<AboutsAdapter.AboutViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder =
        AboutViewHolder(
            ItemAboutsHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class AboutViewHolder(private val binding: ItemAboutsHotelBinding) :
        ViewHolder(binding.root) {
        fun onBind(about: String) {
            binding.tvAbout.text = about
        }
    }
}