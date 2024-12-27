package com.anamorcin.aplicaciontallermvvm.ui.vistas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anamorcin.aplicaciontallermvvm.viewmodels.TallerViewModel
import com.anamorcin.aplicaciontallermvvm.ui.theme.AplicacionTallerMVVMTheme

@Composable
fun ServicioView(modifier: Modifier = Modifier, modelo: TallerViewModel = viewModel()) {

    Column(Modifier.padding(16.dp)) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = modelo.lavado, onCheckedChange = {
                modelo.cambiarLavado(it)
            })
            Spacer(modifier = Modifier.width(20.dp))
            Text("Lavado (10)")
        }
        Divider()
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = modelo.neumaticos, onCheckedChange = {
                modelo.cambiarNeumaticos(it)
            })
            Spacer(modifier = Modifier.width(20.dp))
            Text("Cambio Neumáticos (250)")
        }
        Divider()
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = modelo.aceite, onCheckedChange = {
                modelo.cambiarAceite(it)
            }
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text("Cambio de aceite (75)")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServicioViewPreview() {
    AplicacionTallerMVVMTheme {
        ServicioView()
    }
}