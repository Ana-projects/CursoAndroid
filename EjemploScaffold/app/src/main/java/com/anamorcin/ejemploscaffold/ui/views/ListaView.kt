package com.anamorcin.ejemploscaffold.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anamorcin.ejemploscaffold.ui.theme.EjemploScaffoldTheme

@Composable
fun ListaView(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(40) {
            Text(
                text = "Producto $it",
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaViewPreview() {
    EjemploScaffoldTheme {
        ListaView()
    }
}