package com.iesam.ex_22_23_psp_marzo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iesam.ex_22_23_psp_marzo.domain.Animal
import com.iesam.ex_22_23_psp_marzo.domain.GetAdoptionsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val getAdoptions: GetAdoptionsUseCase) : ViewModel() {
    private var _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadAdoptions() {
        _uiState.postValue(UiState(adoptionList = emptyList()))
        viewModelScope.launch(Dispatchers.IO) {
            getAdoptions.invoke()
        }
    }

    data class UiState(
        val adoptionList: List<Animal> = emptyList()
    )
}