package com.anamorcin.aplicacionalumnos.ui.navegacion

sealed class RutasNavegacion(val ruta: String) {
    object Lista: RutasNavegacion("lista")
    object Detalle: RutasNavegacion("detalle")
}