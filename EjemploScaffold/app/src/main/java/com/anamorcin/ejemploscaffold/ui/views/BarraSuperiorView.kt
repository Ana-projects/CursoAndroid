package com.anamorcin.ejemploscaffold.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.anamorcin.ejemploscaffold.ui.theme.EjemploScaffoldTheme

@Composable
fun BarraSuperiorView() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        IconButton(onClick = { }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
        }
        Text("Título", textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
        IconButton(onClick = { }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Añadir")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BarraSuperiorViewPreview() {
    EjemploScaffoldTheme {
        BarraSuperiorView()
    }
}