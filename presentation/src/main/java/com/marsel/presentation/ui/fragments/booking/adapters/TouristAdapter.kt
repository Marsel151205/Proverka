package com.marsel.presentation.ui.fragments.booking.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.marsel.presentation.R
import com.marsel.presentation.databinding.ItemTouristsBinding

class TouristAdapter : RecyclerView.Adapter<TouristAdapter.TouristViewHolder>() {

    private val items: MutableList<String> = mutableListOf()
    private lateinit var etName: EditText
    private lateinit var etSurname: EditText
    private lateinit var etDateOfBirth: EditText
    private lateinit var etCitizenship: EditText
    private lateinit var etPassportNumber: EditText
    private lateinit var etValidatePeriodPassport: EditText

    fun addItem(item: String) {
        items.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TouristViewHolder =
        TouristViewHolder(
            ItemTouristsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TouristViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    inner class TouristViewHolder(private val binding: ItemTouristsBinding) :
        ViewHolder(binding.root) {
        private var isOpen = true

        fun onBind(tourist: String) {

            etName = binding.etName
            etSurname = binding.etSurname
            etDateOfBirth = binding.etDateOfBirth
            etCitizenship = binding.etCitizenship
            etPassportNumber = binding.etPassportNumber
            etValidatePeriodPassport = binding.etValidityPeriodPassport

            isOpen = adapterPosition == 0

            binding.tvCountTourist.text = "$tourist Турист"

            setupListeners()
        }

        private fun setupListeners() {
            binding.btnManagement.setOnClickListener {
                if (isOpen) {
                    binding.fieldsContainer.visibility = View.GONE
                    isOpen = false
                    Glide.with(binding.btnManagement).load(R.drawable.ic_down)
                        .into(binding.btnManagement)
                } else {
                    binding.fieldsContainer.visibility = View.VISIBLE
                    isOpen = true
                    Glide.with(binding.btnManagement).load(R.drawable.ic_up)
                        .into(binding.btnManagement)
                }
            }
        }
    }

    fun checkUser(): Boolean {
        if (etName.text.isEmpty()) {
            etName.setBackgroundResource(R.drawable.et_error)
            return false
        } else etName.setBackgroundResource(R.drawable.et_background)

        if (etSurname.text.isEmpty()) {
            etSurname.setBackgroundResource(R.drawable.et_error)
            return false
        } else etSurname.setBackgroundResource(R.drawable.et_background)

        if (etDateOfBirth.text.isEmpty()) {
            etDateOfBirth.setBackgroundResource(R.drawable.et_error)
            return false
        } else etDateOfBirth.setBackgroundResource(R.drawable.et_background)

        if (etPassportNumber.text.isEmpty()) {
            etPassportNumber.setBackgroundResource(R.drawable.et_error)
            return false
        } else etPassportNumber.setBackgroundResource(R.drawable.et_background)

        if (etValidatePeriodPassport.text.isEmpty()) {
            etValidatePeriodPassport.setBackgroundResource(R.drawable.et_error)
            return false
        } else etValidatePeriodPassport.setBackgroundResource(R.drawable.et_background)

        if (etCitizenship.text.isEmpty()) {
            etCitizenship.setBackgroundResource(R.drawable.et_error)
            return false
        } else etCitizenship.setBackgroundResource(R.drawable.et_background)

        return true
    }
}