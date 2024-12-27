package com.anamorcin.ejemplocontadormvvm.ui.vistas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anamorcin.ejemplocontadormvvm.ui.theme.EjemploContadorMVVMTheme
import com.anamorcin.ejemplocontadormvvm.viewmodels.ContadorViewModel

@Composable
fun Contador(contador: Int, onIncrementar: () -> Unit, onDecrementar: () -> Unit,
             modifier: Modifier = Modifier
) {
    val isActivoDecrementar = contador > 0
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth().padding(8.dp)
    ){
        Text(
            text = "$contador",
            fontSize = 64.sp
        )
        Row {
            Button(modifier = Modifier.weight(1.0f),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF258328)
                ),
                onClick = onIncrementar) {
                Text("+", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.weight(0.5f))
            Button(modifier = Modifier.weight(1.0f),
                enabled = isActivoDecrementar,
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFBB3847)
                ),
                onClick = onDecrementar) {
                Text("-", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorPreview(modelo: ContadorViewModel = viewModel()) {
    EjemploContadorMVVMTheme() {
        Contador(
            modelo.contador,
            {modelo.incrementarContador()},
            {modelo.decrementarContador()}
        )
    }
}