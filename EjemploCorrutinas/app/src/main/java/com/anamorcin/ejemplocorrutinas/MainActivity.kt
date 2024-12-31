package com.anamorcin.ejemplocorrutinas

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.anamorcin.ejemplocorrutinas.ui.theme.EjemploCorrutinasTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch() {
            withContext(Dispatchers.Default) {
                procesar(1)
            }
            procesar(2)
        }
        Log.d("corrutinas", "Sigue la aplicación")
        enableEdgeToEdge()
        setContent {
            EjemploCorrutinasTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Proceso()
                }
            }
        }
    }
}

@Composable
fun Proceso() {
    var activo by rememberSaveable {
        mutableStateOf(false)
    }
    var resultado by rememberSaveable {
        mutableStateOf(0L)
    }
    var procesando by rememberSaveable {
        mutableStateOf(false)
    }
    val ambitoCorrutina = rememberCoroutineScope()
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)) {
        Button(
            onClick = {
                resultado = 0
                procesando = true
                ambitoCorrutina.launch(Dispatchers.Default) {
                    resultado = calcular()
                    procesando = false
                }
            },
            enabled = !procesando
        ) {
            Text(text = "Procesar")
        }
        Switch(checked = activo, onCheckedChange = { activo = it })
        Text(text = "$resultado")
        Button(
            onClick = {
                ambitoCorrutina.launch(Dispatchers.IO) { guardar(context) }
            },
        ) {
            Text(text = "Guardar")
        }
    }
}

fun calcular(): Long {
    var suma = 0L
    for (i in 0..100_000) { // Podemos poner menos si tarda demasiado
        for (j in 0..100_000) {
            suma += j
        }
    }
    return suma
}

fun guardar(context: Context) {
    val filename = "datos"
    val fileContents = "Esto es una prueba"
    context.openFileOutput(filename, Context.MODE_PRIVATE).use {
        for(i in 1..100) {
            it.write(fileContents.toByteArray())
        }
    }
}

fun procesar(valor: Int) {
    Log.d("corrutinas", "comenzando procesar$valor")
    for(i in 1..10_000) {
        for(j in 1..100_000) { }
    }
    Log.d("corrutinas", "terminando procesar$valor")
}

fun devolver(valor: Int): Int {
    for(i in 1..10_000) {
        for(j in 1..100_000) { }
    }
    return valor * 10
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjemploCorrutinasTheme {
        Proceso()
    }
}