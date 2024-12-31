package com.anamorcin.ejemploroomalumnos.ui.vistas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import com.anamorcin.ejemploroomalumnos.viewmodels.AlumnosViewModel
import com.anamorcin.ejemploroomalumnos.datos.Alumno

@Composable
fun AlumnoView(alumnosViewModel: AlumnosViewModel = hiltViewModel(), alumno: Alumno, modifier: Modifier = Modifier) {
    Column {
        Row(verticalAlignment = Alignment.Top, modifier = Modifier.padding(8.dp)) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Nombre", fontWeight = FontWeight.Bold)
                    Text(alumno.nombre, modifier = Modifier.padding(8.dp))
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Nota", fontWeight = FontWeight.Bold)
                    Text("${alumno.nota}", modifier = Modifier.padding(8.dp))
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { alumnosViewModel.eliminarAlumno(alumno) }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    tint = Color.Red,
                    contentDescription = "Eliminar"
                )
            }
        }
        HorizontalDivider()
    }
}