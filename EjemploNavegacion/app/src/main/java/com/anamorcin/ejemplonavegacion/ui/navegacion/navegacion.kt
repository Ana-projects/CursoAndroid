package com.anamorcin.ejemplonavegacion.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anamorcin.ejemplonavegacion.ui.pantallas.PrincipalPantalla
import com.anamorcin.ejemplonavegacion.ui.pantallas.SegundaPantalla

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RutasNavegacion.Principal.ruta) // Pantalla inicial
    {
        composable(route = RutasNavegacion.Principal.ruta){
            PrincipalPantalla(navController)
        }
        composable(RutasNavegacion.Segunda.ruta + "/{nombre}"){
            backStackEntry -> SegundaPantalla(navController, backStackEntry.arguments?.getString("nombre"))
        }
    }
}