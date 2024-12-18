package com.anamorcin.aplicacionalumnos.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.anamorcin.aplicacionalumnos.ui.pantallas.DetalleAlumnos
import com.anamorcin.aplicacionalumnos.ui.pantallas.ListaAlumnos

@Composable
fun Navegacion(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RutasNavegacion.Lista.ruta
    )
    {
        composable(route = RutasNavegacion.Lista.ruta) {
            ListaAlumnos(navController)
        }
        composable(
            route = RutasNavegacion.Detalle.ruta + "/{idAlumno}",
            arguments = listOf(navArgument(name = "idAlumno"
            ) { type = NavType.IntType })
        )
        { backStackEntry ->
            DetalleAlumnos(
                backStackEntry.arguments?.getInt("idAlumno")
            )
        }
    }
}