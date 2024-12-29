package com.anamorcin.aplicaciontallermvvm.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.neverEqualPolicy

import androidx.lifecycle.ViewModel
import com.anamorcin.aplicaciontallermvvm.modelos.Servicio
import com.anamorcin.aplicaciontallermvvm.modelos.obtenerServicios
import java.util.Locale

class TallerViewModel : ViewModel() {
    var servicios by mutableStateOf(
        obtenerServicios(),
        policy = neverEqualPolicy()
    )
        private set

    var matricula by mutableStateOf("")
        private set

    var total by mutableStateOf(0)
        private set

    fun onMatriculaChanged(nuevaMatricula: String) {
        matricula = nuevaMatricula.uppercase(Locale.ROOT)
    }

    fun cambiar(nuevoEstado: Boolean, servicio: Servicio) {
        servicio.seleccionado = nuevoEstado
        total += servicio.precio * if(nuevoEstado) 1 else -1
        servicios = servicios
    }
}