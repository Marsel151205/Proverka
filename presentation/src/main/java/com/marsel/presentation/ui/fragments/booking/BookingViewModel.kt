package com.marsel.presentation.ui.fragments.booking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marse.domain.tools.Either
import com.marse.domain.usecases.BookingUseCase
import com.marsel.presentation.models.BookingModelUI
import com.marsel.presentation.models.toUI
import com.marsel.presentation.tools.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BookingViewModel(private val bookingUseCase: BookingUseCase) : ViewModel() {

    private val _getBooking = MutableStateFlow<UIState<BookingModelUI>>(UIState.Loading())
    val getBooking = _getBooking.asStateFlow()

    fun fetchBooking() {
        viewModelScope.launch {
            bookingUseCase().collect {
                when (it) {
                    is Either.Left -> {
                        _getBooking.value = UIState.Error(it.message)
                    }
                    is Either.Right -> {
                        _getBooking.value = UIState.Success(it.data.toUI())
                    }
                }
            }
        }
    }
}