package com.marsel.presentation.ui.fragments.number.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.marsel.presentation.databinding.ItemAboutsHotelBinding

class AboutsNumberAdapter :
    ListAdapter<String, AboutsNumberAdapter.AboutsNumberViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutsNumberViewHolder =
        AboutsNumberViewHolder(
            ItemAboutsHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AboutsNumberViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    class AboutsNumberViewHolder(private val binding: ItemAboutsHotelBinding) :
        ViewHolder(binding.root) {
        fun onBind(about: String) {
            binding.tvAbout.text = about
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