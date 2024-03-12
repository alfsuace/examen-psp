package com.iesam.ex_22_23_psp_marzo.presentation

import android.database.Observable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.iesam.ex_22_23_psp_marzo.R
import com.iesam.ex_22_23_psp_marzo.data.AdoptionDataRepository
import com.iesam.ex_22_23_psp_marzo.data.remote.AdoptionRemoteDataSource
import com.iesam.ex_22_23_psp_marzo.domain.GetAdoptionsUseCase

class MainActivity : AppCompatActivity() {

    private val repository = AdoptionDataRepository(
        AdoptionRemoteDataSource()
    )

    private val viewModel = MainViewModel(
        GetAdoptionsUseCase(repository)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupObservers()
    }

    override fun onResume() {
        super.onResume()
        initAdoptions()
    }

    private fun setupObservers() {
        val observer = Observer<MainViewModel.UiState>{
            it.adoptionList
        }
        viewModel.uiState.observe(this, observer)
    }

    private fun initAdoptions() {
        viewModel.loadAdoptions()
    }
}