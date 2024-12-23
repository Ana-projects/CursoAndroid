package com.anamorcin.aplicaciontaller.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anamorcin.aplicaciontaller.ui.theme.AplicacionTallerTheme
import java.util.Locale

@Composable
fun Taller(modifier: Modifier = Modifier) {
    var total by rememberSaveable {
        mutableStateOf(0)
    }

    var matricula by rememberSaveable {
        mutableStateOf("")
    }

    var mostrarResumen by rememberSaveable {
        mutableStateOf(false)
    }

    Column(modifier.padding(16.dp)) {
        Text(
            "Taller",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize
        )

        TextField(
            value = matricula,
            onValueChange = { matricula = it.uppercase(Locale.ROOT) },
            label = { Text("Introduce la matrícula") }
        )
        Servicio(onCambiado = { total += it })
        Text(
            "Total: $total",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            textAlign = TextAlign.End,
            modifier = modifier.fillMaxWidth()
        )
        Button(onClick = { mostrarResumen = true }) {
            Text(
                "Mostrar resumen", textAlign = TextAlign.Center,
                modifier = modifier
                    .weight(1f) // Para que ocupe todo el ancho
            )
        }
        if (mostrarResumen) {
            DialogResumen(mensaje = "El total es $total") {
                mostrarResumen = false
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TallerPreview() {
    AplicacionTallerTheme {
        Taller()
    }
}