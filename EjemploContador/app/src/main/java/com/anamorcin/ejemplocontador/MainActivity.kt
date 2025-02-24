package com.anamorcin.ejemplocontador

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.anamorcin.ejemplocontador.ui.theme.EjemploContadorTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploContadorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    var contador by rememberSaveable { mutableStateOf(0) }
                    Contador(
                        contador = contador,
                        onIncrementar = {contador++},
                        onDecrementar = {contador--}
                    )
                }
            }
        }
    }
}

@Composable
fun Contador(contador: Int, onIncrementar: () -> Unit, onDecrementar: () -> Unit,
    modifier: Modifier = Modifier) {
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
fun ContadorPreview() {
    EjemploContadorTheme {
        Contador(contador = 0, onIncrementar = {}, onDecrementar = {})
    }
}