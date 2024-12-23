package com.anamorcin.casopracticomodulo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anamorcin.casopracticomodulo3.ui.theme.CasoPracticoModulo3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CasoPracticoModulo3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var red by rememberSaveable {  mutableStateOf(0f) }
    var blue by rememberSaveable {  mutableStateOf(0f) }
    var green by rememberSaveable {  mutableStateOf(0f) }
    var negrita by rememberSaveable {  mutableStateOf(false) }
    var cursiva by rememberSaveable {  mutableStateOf(false) }
    Column (
        modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "HOLA",
            fontSize = 80.sp,
            color = Color(red.toInt(), green.toInt(), blue.toInt()),
            fontWeight = if (negrita) FontWeight.Bold else FontWeight.Normal,
            fontStyle = if (cursiva) FontStyle.Italic else FontStyle.Normal,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(text = "Rojo")
        Slider(
            value = red,
            onValueChange = { red = it },
            valueRange = 0f..255f,
            modifier = modifier.fillMaxWidth()
        )
        Text(text = "Azul")
        Slider(
            value = blue,
            onValueChange = { blue = it },
            valueRange = 0f..255f,
            modifier = modifier.fillMaxWidth()
        )
        Text(text = "Verde")
        Slider(
            value = green,
            onValueChange = { green = it },
            valueRange = 0f..255f,
            modifier = modifier.fillMaxWidth()
        )
        Row {
            Checkbox(
                checked = negrita,
                onCheckedChange = { negrita = it },
            )
            Text(
                text = "Negrita",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        Row {
            Checkbox(
                checked = cursiva,
                onCheckedChange = { cursiva = it },
            )
            Text(
                text = "Cursiva",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CasoPracticoModulo3Theme {
        Greeting()
    }
}