package com.anamorcin.ejemplocompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.anamorcin.ejemplocompose1.ui.theme.EjemploCompose1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploCompose1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "Hola $name!",
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = modifier
                .background(Color.Green)
                .padding(6.dp)
                .background(Color(0xFF5FAAF1))
        )
        Text(
            text = "Adiós $name!",
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = modifier
                .padding(6.dp)
        )
        for (i in 1..5) {
            Text("$i")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjemploCompose1Theme {
        Greeting("Android")
    }
}