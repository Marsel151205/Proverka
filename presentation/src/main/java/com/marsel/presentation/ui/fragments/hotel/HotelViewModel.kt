package com.marsel.presentation.ui.fragments.hotel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marse.domain.tools.Either
import com.marse.domain.usecases.HotelUseCase
import com.marsel.presentation.models.HotelModelUI
import com.marsel.presentation.models.toUI
import com.marsel.presentation.tools.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HotelViewModel(private val hotelUseCase: HotelUseCase) : ViewModel() {

    private val _hotel = MutableStateFlow<UIState<HotelModelUI>>(UIState.Loading())
    val hotel = _hotel.asStateFlow()

    fun getHotelData() {
        viewModelScope.launch {
            hotelUseCase().collect {
                when (it) {
                    is Either.Left -> {
                        Log.e("marsel", "getHotelData: ${it.message}", )
                        _hotel.value = UIState.Error(it.message)
                    }
                    is Either.Right -> {
                        _hotel.value = UIState.Success(it.data.toUI())
                    }
                }
            }
        }
    }
}