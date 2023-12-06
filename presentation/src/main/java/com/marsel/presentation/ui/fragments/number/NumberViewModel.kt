package com.marsel.presentation.ui.fragments.number

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marse.domain.tools.Either
import com.marse.domain.usecases.NumberUseCase
import com.marsel.presentation.models.NumberModelUI
import com.marsel.presentation.models.toUI
import com.marsel.presentation.tools.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NumberViewModel(private val numberUseCase: NumberUseCase) : ViewModel() {

    private val _hotelsData = MutableStateFlow<UIState<List<NumberModelUI>>>(UIState.Loading())
    val hotelsData = _hotelsData.asStateFlow()

    fun getHotelsData() {
        viewModelScope.launch {
            numberUseCase().collect {
                when (it) {
                    is Either.Left -> {
                        _hotelsData.value = UIState.Error(it.message)
                    }
                    is Either.Right -> {
                        _hotelsData.value = UIState.Success(it.data.map { it.toUI() })
                    }
                }
            }
        }
    }
}