package com.anamorcin.ejemplocontadormvvm.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {
    var contador by mutableStateOf(0)
        private set

    fun incrementarContador() {
        contador++
    }

    fun decrementarContador() {
        contador--
    }
}
