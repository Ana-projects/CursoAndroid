package com.anamorcin.ejemploroomalumnos.ui.vistas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import com.anamorcin.ejemploroomalumnos.viewmodels.AlumnosViewModel

@Composable
fun InicialView(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { BarraSuperiorView() },
        floatingActionButton = {
            FABAlumnosView()
        }
    ) { paddingValues ->
        ListAlumnosView(
            modifier = Modifier.padding(paddingValues),
        )
    }
}