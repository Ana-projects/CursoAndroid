package com.anamorcin.ejercicioestados

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anamorcin.ejercicioestados.ui.theme.EjercicioEstadosTheme
import java.util.concurrent.Executors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjercicioEstadosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tareas(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

enum class Estado {
    INICIADO, PROCESANDO, FINALIZADO
}

fun ejecutarTarea(onCambioEstado: (Estado, Int) -> Unit, onTerminar: (Long) -> Unit) {
    val executor = Executors.newSingleThreadExecutor()
    val handler = Handler(Looper.getMainLooper())
    onCambioEstado(Estado.INICIADO, 0)
    executor.execute {
        var suma = 0L
        for (i in 0..20_000) {
            for (j in 0..100_000) {
                suma += j
            }
            if (i % 1000 == 0) {
                onCambioEstado(Estado.PROCESANDO, i)
            }
        }
        handler.post {
            onCambioEstado(Estado.FINALIZADO, 0)
            onTerminar(suma)
        }
    }
}

@Composable
fun Tareas(modifier: Modifier = Modifier) {
    var resultado by rememberSaveable {
        mutableStateOf(0L)
    }
    var estado by rememberSaveable {
        mutableStateOf("")
    }
    var activadoBoton by rememberSaveable {
        mutableStateOf(true)
    }

    Column(modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(enabled = activadoBoton,
            onClick = {
                resultado = 0
                activadoBoton = false
                ejecutarTarea({ estadoActual, valor ->
                    estado = "${estadoActual}: ${valor}"
                }) { it ->
                    resultado = it
                    activadoBoton = true
                }
            }
        ) {
            Text("Ejecuta tarea 1")
        }
        Text("Estado $estado")
        Text("Resultado $resultado")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjercicioEstadosTheme {
        Tareas()
    }
}