package com.anamorcin.ejemplodiffutil.modelos

fun obtenerAlumnos(numero: Int): ArrayList<Alumno> {
    val nombres = listOf("Laura", "Sergio", "Eva", "Pedro", "Sandra", "Emilio",
        "Montse" )
    val lista = ArrayList<Alumno>()
    for(i in 1..numero) {
        lista.add(Alumno(i, nombres[(0..<nombres.count()).random()], (0..10).random(),
            when ((0..1).random()) { 0 -> false else -> true }))
    }
    return lista
}