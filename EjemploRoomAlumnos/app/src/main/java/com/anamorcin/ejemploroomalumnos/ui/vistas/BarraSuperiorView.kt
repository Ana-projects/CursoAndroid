package com.anamorcin.ejemploroomalumnos.ui.vistas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anamorcin.ejemploroomalumnos.ui.theme.EjemploRoomAlumnosTheme
import com.anamorcin.ejemploroomalumnos.viewmodels.AlumnosViewModel

@Composable
fun BarraSuperiorView(
    alumnosViewModel: AlumnosViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Text("Colegio", textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
        IconButton(onClick = { alumnosViewModel.eliminarAlumnos() }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Vaciar")
        }
    }
}
