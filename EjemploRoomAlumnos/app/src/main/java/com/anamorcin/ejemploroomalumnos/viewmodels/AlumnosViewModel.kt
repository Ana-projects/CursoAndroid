package com.anamorcin.ejemploroomalumnos.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anamorcin.ejemploroomalumnos.datos.Alumno
import com.anamorcin.ejemploroomalumnos.datos.RepositorioAlumnos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlumnosViewModel @Inject constructor(private val repositorio: RepositorioAlumnos) : ViewModel() {
    val alumnos = repositorio.obtenerAlumnos()

    fun insertarAlumno(alumno: Alumno) =
        viewModelScope.launch(Dispatchers.IO)
        {
            repositorio.insertarAlumno(alumno)
        }

    fun eliminarAlumno(alumno: Alumno) =
        viewModelScope.launch(Dispatchers.IO) {
            repositorio.eliminarAlumno(alumno)
        }

    fun actualizarAlumno(alumno: Alumno) =
        viewModelScope.launch(Dispatchers.IO) {
            repositorio.actualizarAlumno(alumno)
        }

    fun eliminarAlumnos() =
        viewModelScope.launch(Dispatchers.IO) {
            repositorio.eliminarAlumnos()
        }
}