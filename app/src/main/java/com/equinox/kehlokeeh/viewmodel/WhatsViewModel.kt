package com.equinox.kehlokeeh.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.equinox.kehlokeeh.data.WhatResponse
import com.equinox.kehlokeeh.model.WhatsRepository
import kotlinx.coroutines.launch

class WhatsViewModel : ViewModel() {

    val productLiveData = MutableLiveData<WhatResponse>()
    val isLoading = MutableLiveData<Boolean>()
    private val whatsRepository: WhatsRepository = WhatsRepository()

    fun getProduct(rn: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val product = whatsRepository.get(rn)
            product?.let {
                productLiveData.postValue(it)
            }
            isLoading.postValue(false)
        }
    }
}