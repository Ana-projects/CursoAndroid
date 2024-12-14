package com.anamorcin.ejemplonavegacion.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun SegundaPantalla(navController: NavController, nombre: String?) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE91E63))) {
        Text(text = "Hola $nombre",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold)
        Button(modifier = Modifier.padding(5.dp),
            onClick = {
                navController.popBackStack()
            }
            ){
            Text(text = "volver")
        }
    }
}

// No es obligatorio que creemos la preview
@Preview(showBackground = true)
@Composable
fun SegundaPantallaPreview() {
    EjemploNavegacionTheme {
        SegundaPantalla(NavController(LocalContext.current), "Laura" )
    }
}