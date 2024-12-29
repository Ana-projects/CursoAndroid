package com.anamorcin.ejemploscaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anamorcin.ejemploscaffold.ui.theme.EjemploScaffoldTheme
import com.anamorcin.ejemploscaffold.ui.views.InicialView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjemploScaffoldTheme(dynamicColor = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InicialView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InicialViewPreview() {
    EjemploScaffoldTheme {
        InicialView()
    }
}