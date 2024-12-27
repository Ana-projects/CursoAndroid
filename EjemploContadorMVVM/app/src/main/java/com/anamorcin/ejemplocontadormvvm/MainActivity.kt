package com.anamorcin.ejemplocontadormvvm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anamorcin.ejemplocontadormvvm.ui.theme.EjemploContadorMVVMTheme
import com.anamorcin.ejemplocontadormvvm.ui.vistas.Contador
import com.anamorcin.ejemplocontadormvvm.viewmodels.ContadorViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploContadorMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val modelo: ContadorViewModel = viewModel()
                    Contador(
                        modelo,
                        { modelo.incrementarContador() },
                        { modelo.decrementarContador() }
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ContadorPreview(modelo: ContadorViewModel = viewModel()) {
    EjemploContadorMVVMTheme() {
        Contador(
            modelo,
            {modelo.incrementarContador()},
            {modelo.decrementarContador()}
        )
    }
}