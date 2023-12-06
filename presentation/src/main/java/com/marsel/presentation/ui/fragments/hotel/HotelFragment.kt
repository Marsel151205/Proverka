package com.marsel.presentation.ui.fragments.hotel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.marsel.presentation.R
import com.marsel.presentation.databinding.FragmentHotelBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.marsel.presentation.tools.UIState
import com.marsel.presentation.ui.fragments.hotel.adapters.AboutsAdapter
import com.marsel.presentation.ui.fragments.hotel.adapters.HotelImagesAdapter
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

class HotelFragment : Fragment() {

    private var _binding: FragmentHotelBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HotelViewModel by viewModel()
    private val imagesAdapter = HotelImagesAdapter()
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHotelBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRequest()
        setupListeners()
        setupView()
    }

    private fun setupView() {
        binding.vpImages.adapter = imagesAdapter
        binding.diImages.attachTo(binding.vpImages)
    }

    private fun setupRequest() {
        lifecycleScope.launch {
            viewModel.getHotelData()
            viewModel.hotel.collect {
                when (it) {
                    is UIState.Error -> {
                        Log.e("marsel", "setupRequest: ${it.error}")
                    }

                    is UIState.Success -> {
                        val model = it.data
                        Log.e("marsel", "setupRequest: ${it.data}")
                        with(binding) {
                            tvName.text = model.name
                            tvAddress.text = model.address
                            val formattedNumber =
                                NumberFormat.getNumberInstance(Locale.getDefault())
                                    .format(model.minimalPrice)
                            tvMinimalPrice.text = "от $formattedNumber ₽"
                            tvPriceForIt.text = model.priceForIt
                            tvRating.text = model.rating.toString()
                            tvNameRating.text = model.ratingName
                            imagesAdapter.submitList(model.images)
                            tvDescription.text = model.aboutTheHotel.description
                            val adapter = AboutsAdapter(model.aboutTheHotel.peculiarities)
                            binding.rvAbouts.adapter = adapter

                            bundle.putString("hotelName", model.name)
                        }
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

    private fun setupListeners() {
        with(binding) {
            btnNext.setOnClickListener {
                findNavController().navigate(R.id.action_hotelFragment_to_numberFragment, bundle)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}