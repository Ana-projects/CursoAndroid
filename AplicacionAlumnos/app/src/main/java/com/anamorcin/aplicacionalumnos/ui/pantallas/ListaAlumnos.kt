package com.anamorcin.aplicacionalumnos.ui.pantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anamorcin.aplicacionalumnos.modelos.obtenerAlumnos
import com.anamorcin.aplicacionalumnos.ui.navegacion.RutasNavegacion

@Composable
fun ListaAlumnos(navController: NavController, modifier: Modifier = Modifier) {
    val alumnos = obtenerAlumnos()

    LazyColumn() {
        items(alumnos) { alumno ->
            Text(
                alumno.nombre,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate(
                        RutasNavegacion.Detalle.ruta + "/${alumno.id}") }
            )
            Divider(color = Color.LightGray)
        }
    }
}