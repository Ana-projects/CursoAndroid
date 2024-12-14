package com.anamorcin.ejemplonavegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anamorcin.ejemplonavegacion.ui.navegacion.Navegacion
import com.anamorcin.ejemplonavegacion.ui.theme.EjemploNavegacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploNavegacionTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    Navegacion(
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavegacionPreview() {
    EjemploNavegacionTheme {
        Navegacion()
    }
}