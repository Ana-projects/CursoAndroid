package com.anamorcin.ejemplonavegacion.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anamorcin.ejemplonavegacion.ui.theme.EjemploNavegacionTheme

@Composable
fun PrincipalPantalla(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var hayNombre = nombre.length > 0
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF26D8C7))) {
        Text(text = "Pantalla principal",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold)
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Introduce tu nombre") })
        Button(
            modifier = Modifier.padding(5.dp),
            onClick = {
                navController.navigate("segunda/$nombre")
            },
            enabled = hayNombre
        ) {
            Text(
                text = "Ir a la segunda pantalla",
            )
        }
    }
}

// No es obligatorio que creemos la preview
@Preview(showBackground = true)
@Composable
fun PrincipalPantallaPreview() {
    EjemploNavegacionTheme {
        PrincipalPantalla(NavController(LocalContext.current))
    }
}