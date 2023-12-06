package com.marsel.presentation.ui.fragments.booking

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.marsel.presentation.R
import com.marsel.presentation.databinding.FragmentBookingBinding
import com.marsel.presentation.models.BookingModelUI
import com.marsel.presentation.tools.UIState
import com.marsel.presentation.ui.fragments.booking.adapters.TouristAdapter
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

class BookingFragment : Fragment() {

    private var _binding: FragmentBookingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BookingViewModel by viewModel()
    private val touristAdapter = TouristAdapter()
    private val list = arrayListOf<String>()
    private var listSize = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadLocalData()
        setupView()
        setupRequest()
        setupListeners()
    }

    private fun loadLocalData() {
        list.addAll(
            listOf(
                "Первый",
                "Второй",
                "Третий",
                "Четвертый",
                "Пятый",
                "Шестой",
                "Седьмой",
                "Восьмой",
                "Девятый",
                "Десятый"
            )
        )
    }

    private fun setupView() {
        setupTourist()
        setupValidate()
    }

    private fun setupTourist() {
        touristAdapter.addItem(list[listSize])
        binding.rvTourist.adapter = touristAdapter
        listSize++
    }

    private fun setupRequest() {
        viewModel.fetchBooking()
        setupSubscribe()
    }

    private fun setupSubscribe() {
        lifecycleScope.launch {
            viewModel.getBooking.collect {
                when (it) {
                    is UIState.Error -> {
                        Log.e("marsel", "setupSubscribe: ${it.error}")
                    }

                    is UIState.Success -> {
                        setData(it.data)
                    }

                    is UIState.Loading -> {
                        // Loading
                    }

                    is UIState.Idle -> {
                        // Idle
                    }
                }
            }
        }
    }

    private fun setupValidate() {
        binding.etEmail.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                if (!isValidEmail(binding.etEmail.text.toString())) {
                    binding.etEmail.setBackgroundResource(R.drawable.et_error)
                }
            } else {
                binding.etEmail.setBackgroundResource(R.drawable.et_background)
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        return email.matches(emailRegex.toRegex())
    }

    private fun setupListeners() {
        binding.btnAddTourist.setOnClickListener {
            if (touristAdapter.checkUser()) {
                try {
                    touristAdapter.addItem(list[listSize])
                    listSize++
                } catch (exception: IndexOutOfBoundsException) {
                    Toast.makeText(
                        requireContext(),
                        "Максимальное кол-во туристов",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }else Toast.makeText(
                requireContext(),
                "Заполните предыдущего туриста",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.btnPay.setOnClickListener {
            if (touristAdapter.checkUser()) {
                if (isValidEmail(binding.etEmail.text.toString())) {
                    findNavController().navigate(R.id.action_bookingFragment_to_paidFragment)
                } else {
                    binding.etEmail.setBackgroundResource(R.drawable.et_error)
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData(model: BookingModelUI) {
        with(binding) {
            tvRating.text = model.rating.toString()
            tvNameRating.text = model.ratingName
            tvHotelName.text = model.hotelName
            tvHotelAddress.text = model.hotelAddress
            tvDeparture.text = model.departure
            tvArrivalCountry.text = model.arrivalCountry
            tvNumberOfNight.text = model.numberOfNights.toString()
            tvTourDate.text = "${model.dateStart} - ${model.dateStop}"
            tvHotel.text = model.hotelName
            tvRoom.text = model.room
            tvNutrition.text = model.nutrition
            tvTour.text =
                "${NumberFormat.getNumberInstance(Locale.getDefault()).format(model.price)} ₽"
            tvFuelCollection.text =
                "${NumberFormat.getNumberInstance(Locale.getDefault()).format(model.fuelCharge)} ₽"
            tvServiceFree.text = "${
                NumberFormat.getNumberInstance(Locale.getDefault()).format(model.serviceCharge)
            } ₽"
            val paid = model.price + model.fuelCharge + model.serviceCharge
            tvPaid.text = "${NumberFormat.getNumberInstance(Locale.getDefault()).format(paid)} ₽"
            btnPay.text =
                "Оплатить ${NumberFormat.getNumberInstance(Locale.getDefault()).format(paid)} ₽"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}