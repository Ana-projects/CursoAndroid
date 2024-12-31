package com.anamorcin.ejemploroomalumnos.ui.vistas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anamorcin.ejemploroomalumnos.viewmodels.AlumnosViewModel

@Composable
fun ListAlumnosView(alumnosViewModel: AlumnosViewModel = hiltViewModel(), modifier: Modifier = Modifier) {
    val alumnos by alumnosViewModel.alumnos.collectAsState(initial = emptyList())

    Column(modifier = modifier) {
        LazyColumn {
            items(alumnos) { alumno ->
                AlumnoView(alumno = alumno)
            }
        }
    }
}