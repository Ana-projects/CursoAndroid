package com.anamorcin.ejemplotareas

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import com.anamorcin.ejemplotareas.ui.theme.EjemploTareasTheme
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploTareasTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Tareas(
                    )
                }
            }
        }
    }
}

@Composable
fun Tareas(modifier: Modifier = Modifier) {
    var resultado by rememberSaveable {
        mutableStateOf(0L)
    }
    var activadoBoton1 by rememberSaveable {
        mutableStateOf(true)
    }
    var activadoBoton2 by rememberSaveable {
        mutableStateOf(true)
    }
    var activadoBoton3 by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(enabled = activadoBoton1,
            onClick = {
                resultado = 0
                activadoBoton1 = false
                ejecutarTarea1 { it ->
                    resultado = it
                    activadoBoton1 = true
                }
            }
        ) {
            Text("Ejecuta tarea 1")
        }
        Button(enabled = activadoBoton2,
            onClick = {
                resultado = 0
                activadoBoton2 = false
                thread {
                    ejecutarTarea1 {
                        resultado = it
                        activadoBoton2 = true
                    }
                }
            }
        ) {
            Text("Ejecuta tarea 2")
        }
        Button(enabled = activadoBoton3,
            onClick = {
                resultado = 0
                activadoBoton3 = false
                thread {
                    ejecutarTarea3 {
                        resultado = it
                        activadoBoton3 = true
                    }
                }
            }
        ) {
             Text("Ejecuta tarea 3")
        }
        Text("Resultado $resultado")
    }
}

fun ejecutarTarea1(onTerminar: (Long) -> Unit) {
    // Ejecutamos una tarea que lleve su tiempo
    var suma = 0L
    for (i in 0..100_000) {
        for (j in 0..100_000) {
            suma += j
        }
    }
    onTerminar(suma)
}

fun ejecutarTarea3(onTerminar: (Long) -> Unit) {
    val executor = Executors.newSingleThreadExecutor()
    val handler = Handler(Looper.getMainLooper())
    executor.execute {
        var suma = 0L
        for (i in 0..100_000) {
            for (j in 0..100_000) {
                suma += j
            }
        }
        handler.post {
            onTerminar(suma)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjemploTareasTheme {
        Tareas()
    }
}