package com.anamorcin.ejemploscaffold.ui.views

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anamorcin.ejemploscaffold.ui.theme.EjemploScaffoldTheme
import kotlinx.coroutines.launch

@Composable
fun InicialView() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = { BarraSuperiorView() },
        bottomBar = { BarraInferiorView() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        val resultado = snackbarHostState.showSnackbar(
                            "Snackbar ",
                            actionLabel = "Cerrar",
                            duration = SnackbarDuration.Long,
                            withDismissAction = true
                        )
                        when (resultado) {
                            SnackbarResult.Dismissed -> {
                                Log.i("snack", "Cerrado")
                            }
                            SnackbarResult.ActionPerformed -> {
                                Log.i("snack", "Aceptado")
                            }
                        }
                        snackbarHostState.showSnackbar(
                            "Snackbar ",
                            actionLabel = "Cerrar",
                            duration = SnackbarDuration.Long,
                            withDismissAction = true,
                        )
                    }
                },
            ) {
                Icon(Icons.Filled.Add, "Añadir")
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) {
        ListaView(modifier = Modifier.padding(it))
    }
}

@Preview(showBackground = true)
@Composable
fun InicialViewPreview() {
    EjemploScaffoldTheme {
        InicialView()
    }
}