package com.marsel.presentation.ui.fragments.hotel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.marsel.presentation.databinding.ItemImageBinding

class HotelImagesAdapter : ListAdapter<String, HotelImagesAdapter.ImagesViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder =
        ImagesViewHolder(
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    class ImagesViewHolder(private val binding: ItemImageBinding) : ViewHolder(binding.root) {
        fun onBind(image: String) {
            Glide.with(binding.ivHotel).load(image).into(binding.ivHotel)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(
                oldItem: String,
                newItem: String
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: String,
                newItem: String
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}