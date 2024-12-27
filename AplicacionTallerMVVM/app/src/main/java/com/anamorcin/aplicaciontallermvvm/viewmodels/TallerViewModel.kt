package com.anamorcin.aplicaciontallermvvm.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.Locale

class TallerViewModel : ViewModel() {
    var lavado by mutableStateOf(false)
        private set
    var aceite by mutableStateOf(false)
        private set
    var neumaticos by mutableStateOf(false)
        private set

    var matricula by mutableStateOf("")
        private set
    var total by mutableStateOf(0)
        private set

    fun onMatriculaChanged(nuevaMatricula: String) {
        matricula = nuevaMatricula.uppercase(Locale.ROOT)
    }

    fun cambiarLavado(nuevoEstado: Boolean) {
        lavado = nuevoEstado
        total += 10 * if(lavado) 1 else -1
    }
    fun cambiarAceite(nuevoEstado: Boolean) {
        aceite = nuevoEstado
        total += 75 * if(aceite) 1 else -1
    }
    fun cambiarNeumaticos(nuevoEstado: Boolean) {
        neumaticos = nuevoEstado
        total += 250 * if(neumaticos) 1 else -1
    }
}