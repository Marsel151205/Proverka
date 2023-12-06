package com.marsel.presentation.ui.fragments.number

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.marsel.presentation.R
import com.marsel.presentation.databinding.FragmentNumberBinding
import com.marsel.presentation.tools.UIState
import com.marsel.presentation.ui.fragments.number.adapters.NumberAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NumberFragment : Fragment() {

    private var _binding: FragmentNumberBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NumberViewModel by viewModel()
    private val numberAdapter = NumberAdapter(this::onClickItem)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNumberBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRequest()
        setupView()
    }

    private fun setupRequest() {
        viewModel.getHotelsData()
        setupSubscribe()
    }

    private fun setupSubscribe() {
        lifecycleScope.launch {
            viewModel.hotelsData.collect {
                when (it) {
                    is UIState.Error -> {
                        Log.e("marsel", "setupSubscribe: ${it.error}")
                    }

                    is UIState.Success -> {
                        numberAdapter.submitList(it.data)
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

    private fun setupView() {
        val textToolbar = requireActivity().findViewById<TextView>(R.id.tv_fragment_name)
        textToolbar.text = arguments?.getString("hotelName")
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvNumbers.adapter = numberAdapter
    }

    private fun onClickItem() {
        findNavController().navigate(R.id.action_numberFragment_to_bookingFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}