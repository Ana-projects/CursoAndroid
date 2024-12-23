package com.anamorcin.aplicaciontaller.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anamorcin.aplicaciontaller.ui.theme.AplicacionTallerTheme

@Composable
fun Servicio(onCambiado: (Int) -> Unit, modifier: Modifier = Modifier) {
    var lavado by rememberSaveable {
        mutableStateOf(false)
    }
    var aceite by rememberSaveable {
        mutableStateOf(false)
    }
    var neumaticos by rememberSaveable {
        mutableStateOf(false)
    }
    Column(Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = lavado, onCheckedChange = {
                lavado = it
                onCambiado(10 * if (lavado) 1 else -1)
            })
            Spacer(modifier = Modifier.width(20.dp))
            Text("Lavado (10)")
        }
        Divider()
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = neumaticos, onCheckedChange = {
                neumaticos = it
                onCambiado(250 * if (neumaticos) 1 else -1)
            })
            Spacer(modifier = Modifier.width(20.dp))
            Text("Cambio Neumáticos (250)")
        }
        Divider()
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = aceite, onCheckedChange = {
                aceite = it
                onCambiado(75 * if (aceite) 1 else -1)
            }
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text("Cambio de aceite (75)")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServicioPreview() {
    AplicacionTallerTheme {
        Servicio(onCambiado = { })
    }
}