package com.anamorcin.casopractico.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.anamorcin.casopractico.modelos.Producto

import com.anamorcin.casopractico.modelos.obtenerProductos

@Composable
fun ListaProductos(modifier: Modifier = Modifier) {
    var productos = obtenerProductos()

    LazyColumn() {
        items(productos) { producto ->
            FilaProducto(producto)
        }
    }
}

@Composable
fun FilaProducto(producto: Producto) {
    val stockColor = when {
        producto.stock < 6 -> Color.Red
        producto.stock < 10 -> Color.Blue
        else -> Color.Green
    }

    Column (modifier = Modifier.padding(5.dp)) {
        Text(
            producto.nombre,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Row {
            Text(
                "Precio: ${producto.precio}",
                fontSize = 16.sp
            )
            Text(
                "Stock: ${producto.stock}",
                fontSize = 16.sp,
                color = stockColor,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End
            )
        }
        HorizontalDivider()
    }
}

@Preview(showBackground = true)
@Composable
fun ListaProductosPreview() {
    ListaProductos()
}