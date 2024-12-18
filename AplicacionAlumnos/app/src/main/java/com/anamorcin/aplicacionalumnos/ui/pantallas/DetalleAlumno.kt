package com.anamorcin.aplicacionalumnos.ui.pantallas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anamorcin.aplicacionalumnos.modelos.obtenerAlumnos
import com.anamorcin.aplicacionalumnos.ui.theme.AplicacionAlumnosTheme

@Composable
fun DetalleAlumnos(idAlumno: Int?, modifier: Modifier = Modifier) {

    // Suponemos que el alumno siempre existe
    val alumno = obtenerAlumnos().filter { it.id == idAlumno }[0]
    /* Usamos una variable para poner en diferente color el texto según esté aprobado
    o no */
    val color = if (alumno.apto) Color.Green else Color.Red

    Box {
        Column(modifier = Modifier.padding(8.dp)) {
            Text("Nombre", fontWeight = FontWeight.Bold)
            Text(alumno.nombre, modifier = Modifier.padding(8.dp))
            Text("Nota", fontWeight = FontWeight.Bold)
            Text("${alumno.nota}", modifier = Modifier.padding(8.dp))
            Text("Resultado", fontWeight = FontWeight.Bold)
            Text(
                "Apto",
                fontWeight = FontWeight.Bold,
                color = color,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetalleAlumnos() {
    AplicacionAlumnosTheme {
        DetalleAlumnos(1)
    }
}