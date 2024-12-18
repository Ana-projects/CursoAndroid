package com.anamorcin.aplicacionalumnos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anamorcin.aplicacionalumnos.ui.navegacion.Navegacion
import com.anamorcin.aplicacionalumnos.ui.theme.AplicacionAlumnosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicacionAlumnosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerpadding ->
                    Navegacion(
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AplicacionAlumnosTheme {
        Navegacion()
    }
}