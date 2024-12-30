package com.anamorcin.ejemplohilt.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.anamorcin.ejemplohilt.datos.AcademiaLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AcademiaViewModel @Inject constructor(private val academiaLoader: AcademiaLoader): ViewModel() {
    var alumnos by mutableStateOf(
        academiaLoader.cargarAlumnos(),
    )
        private set
}