package com.anamorcin.ejemplohilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import com.anamorcin.ejemplohilt.datos.AcademiaLoader
import com.anamorcin.ejemplohilt.datos.Alumno
import com.anamorcin.ejemplohilt.ui.theme.EjemploHiltTheme
import com.anamorcin.ejemplohilt.viewmodels.AcademiaViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var academiaLoader: AcademiaLoader
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploHiltTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ListaAlumnos()
                }
            }
        }
    }
}

@Composable
fun ListaAlumnos(modifier: Modifier = Modifier,
                 academiaViewModel: AcademiaViewModel = hiltViewModel()) {
    LazyColumn {
        items(academiaViewModel.alumnos){
            Text(it.nombre)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjemploHiltTheme {
        ListaAlumnos()
    }
}