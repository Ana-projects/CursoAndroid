package com.anamorcin.aplicaciontallermvvm.ui.vistas

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anamorcin.aplicaciontallermvvm.viewmodels.TallerViewModel
import com.anamorcin.aplicaciontallermvvm.ui.theme.AplicacionTallerMVVMTheme

@Composable
fun TallerView(modifier: Modifier = Modifier, modelo: TallerViewModel = viewModel()) {

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
            value = modelo.matricula,
            onValueChange = { modelo.onMatriculaChanged(it) },
            label = { Text("Introduce la matrícula") }
        )
        ServicioView(modelo = modelo)
        Text(
            "Total: ${modelo.total}",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            textAlign = TextAlign.End,
            modifier = modifier.fillMaxWidth()
        )
        Button(onClick = { mostrarResumen = true }) {
            Text(
                "Mostrar resumen", textAlign = TextAlign.Center,
                modifier = modifier
                    .weight(1f)
            )
        }
        if (mostrarResumen) {
            DialogoResumenView(mensaje = "El total es ${modelo.total}") {
                mostrarResumen = false
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TallerViewPreview() {
    AplicacionTallerMVVMTheme {
        TallerView()
    }
}