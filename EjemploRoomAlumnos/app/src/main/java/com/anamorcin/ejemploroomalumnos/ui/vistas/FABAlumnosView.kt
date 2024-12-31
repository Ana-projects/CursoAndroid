package com.anamorcin.ejemploroomalumnos.ui.vistas

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import com.anamorcin.ejemploroomalumnos.viewmodels.AlumnosViewModel
import com.anamorcin.ejemploroomalumnos.datos.Alumno

@Composable
fun FABAlumnosView(
    alumnosViewModel: AlumnosViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = {
            alumnosViewModel.insertarAlumno(crearAlumno())
        },
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(Icons.Filled.Add, "Añadir")
    }
}

fun crearAlumno(): Alumno {
    val nombres = listOf("Laura", "Eva", "Sergio", "Pedro", "Sara", "Luis")
    val ciudades = listOf("Vigo", "Madrid", "Barcelona")
    val nota = (0..10).random()
    return Alumno(nombre = nombres.random(), ciudad = ciudades.random(), nota = nota)
}