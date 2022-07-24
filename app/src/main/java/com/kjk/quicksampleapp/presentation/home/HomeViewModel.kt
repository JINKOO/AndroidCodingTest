package com.kjk.quicksampleapp.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kjk.quicksampleapp.data.repo.FlightScheduleRepository
import com.kjk.quicksampleapp.domain.entity.ArrivalEntity
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = FlightScheduleRepository()

    private val _flightArrivals = MutableLiveData<List<ArrivalEntity>>()
    val flightArrivals: LiveData<List<ArrivalEntity>>
        get() = _flightArrivals

    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus: LiveData<ApiStatus>
        get() = _apiStatus

    init {
        loadAllArrivals()
    }

    private fun loadAllArrivals() {
        viewModelScope.launch {
            _apiStatus.value = ApiStatus.LOADING
            try {
                _apiStatus.value = ApiStatus.DONE
                _flightArrivals.value = repository.getArrivalsFromRemote()
            } catch (e: Exception) {
                _apiStatus.value = ApiStatus.DONE
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
    ERRIR,
    DONE
}