package com.anamorcin.ejemplonavegacion.ui.navegacion

sealed class RutasNavegacion(val ruta: String) {
    object Principal : RutasNavegacion("principal")
    object Segunda : RutasNavegacion("segunda")
}