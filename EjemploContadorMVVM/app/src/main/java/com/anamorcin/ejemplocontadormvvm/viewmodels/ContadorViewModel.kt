package com.anamorcin.ejemplocontadormvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {
    private val _contador = MutableLiveData(0)
    val contador: LiveData<Int> = _contador

    fun incrementarContador() {
        _contador.value = (_contador.value ?: 0) + 1
    }

    fun decrementarContador() {
        _contador.value = (_contador.value ?: 0) - 1
    }
}
