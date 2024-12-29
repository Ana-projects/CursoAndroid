package com.anamorcin.ejemploscaffold.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anamorcin.ejemploscaffold.ui.theme.EjemploScaffoldTheme

@Composable
fun BarraInferiorView() {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(vertical = 8.dp)
    ) {
        Text("(c) 2023", textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun BarraInferiorViewPreview() {
    EjemploScaffoldTheme {
        BarraInferiorView()
    }
}