package com.marsel.presentation.ui.fragments.number.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.marsel.presentation.databinding.ItemNumberBinding
import com.marsel.presentation.models.NumberModelUI
import com.marsel.presentation.tools.diffUtil.BaseDiffUtilItemCallback
import com.marsel.presentation.ui.fragments.hotel.adapters.HotelImagesAdapter
import java.text.NumberFormat
import java.util.Locale

class NumberAdapter(val onClick: () -> Unit) :
    ListAdapter<NumberModelUI, NumberAdapter.NumberViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder =
        NumberViewHolder(
            ItemNumberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    inner class NumberViewHolder(private val binding: ItemNumberBinding) :
        ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(model: NumberModelUI) {
            with(binding) {
                tvName.text = model.name
                val formattedNumber =
                    NumberFormat.getNumberInstance(Locale.getDefault())
                        .format(model.price)
                tvMinimalPrice.text = "$formattedNumber ₽"
                tvPriceForIt.text = model.pricePer
                val aboutsNumberAdapter = AboutsNumberAdapter()
                aboutsNumberAdapter.submitList(model.peculiarities)
                rvItemAbouts.adapter = aboutsNumberAdapter
                val hotelImagesAdapter = HotelImagesAdapter()
                hotelImagesAdapter.submitList(model.images)
                vpImages.adapter = hotelImagesAdapter
                diImages.attachTo(vpImages)

                btnChooseNumber.setOnClickListener {
                    onClick()
                }
            }
        }
    }
}