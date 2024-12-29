package com.anamorcin.aplicaciontallermvvm.modelos

fun obtenerServicios(): List<Servicio> {
    return listOf(
        Servicio("Lavado", 10),
        Servicio("Cambio Neumáticos", 250),
        Servicio("Cambio de aceite", 75)
    )
}