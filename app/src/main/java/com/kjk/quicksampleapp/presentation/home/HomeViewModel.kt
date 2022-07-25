package com.kjk.quicksampleapp.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kjk.quicksampleapp.data.repo.IncheonAirportRepository
import com.kjk.quicksampleapp.domain.entity.ArrivalEntity
import com.kjk.quicksampleapp.domain.entity.ServiceAirlineEntity
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = IncheonAirportRepository()

    private val _serviceAirlines = MutableLiveData<List<ServiceAirlineEntity>>()
    val serviceAirlines: LiveData<List<ServiceAirlineEntity>>
        get() = _serviceAirlines

    private val _flightArrivals = MutableLiveData<List<ArrivalEntity>>()
    val flightArrivals: LiveData<List<ArrivalEntity>>
        get() = _flightArrivals

    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus: LiveData<ApiStatus>
        get() = _apiStatus

    init {
        loadAllServiceAirlines()
        //loadAllArrivals()
    }


    private fun loadAllServiceAirlines() {
        viewModelScope.launch {
            _apiStatus.value = ApiStatus.LOADING
            try {
                _apiStatus.value = ApiStatus.DONE
                _serviceAirlines.value = repository.getServiceAirlines()
            } catch (e: Exception) {
                _apiStatus.value = ApiStatus.ERROR
                Log.d(TAG, "loadAllServiceAirlines: ${e.message}")
            }
        }
    }


    private fun loadAllArrivals() {
        viewModelScope.launch {
            _apiStatus.value = ApiStatus.LOADING
            try {
                _apiStatus.value = ApiStatus.DONE
                _flightArrivals.value = repository.getArrivalsFromRemote()
            } catch (e: Exception) {
                _apiStatus.value = ApiStatus.ERROR
                Log.d(TAG, "loadAllArrivals: ${e.message}")
            }
        }
    }

    companion object {
        private const val TAG = "HomeViewModel"
    }
}

enum class ApiStatus {
    LOADING,
    ERROR,
    DONE
}