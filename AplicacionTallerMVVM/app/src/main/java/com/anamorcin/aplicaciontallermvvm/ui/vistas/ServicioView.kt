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
       for (servicio in modelo.servicios) {
           Row(verticalAlignment = Alignment.CenterVertically) {
              Switch(
                   checked = servicio.seleccionado,
                   onCheckedChange = {
                       modelo.cambiar(it, servicio)
                   }
               )
               Spacer(Modifier.width(20.dp))
               Text(servicio.nombre + "(${servicio.precio})")
           }
           Divider()
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