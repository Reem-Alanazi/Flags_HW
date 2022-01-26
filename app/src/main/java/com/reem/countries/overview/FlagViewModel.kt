package com.reem.countries.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reem.countries.network.CountryApi
import com.reem.countries.network.Flag
import kotlinx.coroutines.launch


class FlagViewModel : ViewModel() {

    private var _flag = MutableLiveData<String>()
    val flag: LiveData<String> = _flag
    private var _flagPhotos = MutableLiveData<List<Flag>>()
    val flagPhotos: LiveData<List<Flag>> = _flagPhotos

    init {
        getCountryPhotos()
    }

    private fun getCountryPhotos() {

        viewModelScope.launch {
            try {
            _flagPhotos.value = CountryApi.retrofitService.getPhotos().data

        } catch (e: Exception) {
            _flag.value = "Failure: ${e.message}"
        }

        }
    }
}