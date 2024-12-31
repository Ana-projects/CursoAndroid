package com.anamorcin.ejemploroomalumnos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.anamorcin.ejemploroomalumnos.datos.BaseDatosApp
import com.anamorcin.ejemploroomalumnos.datos.RepositorioAlumnos
import com.anamorcin.ejemploroomalumnos.ui.theme.EjemploRoomAlumnosTheme
import com.anamorcin.ejemploroomalumnos.ui.vistas.InicialView
import com.anamorcin.ejemploroomalumnos.viewmodels.AlumnosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjemploRoomAlumnosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InicialView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InicialViewPreview() {
    EjemploRoomAlumnosTheme {
        InicialView()
    }
}