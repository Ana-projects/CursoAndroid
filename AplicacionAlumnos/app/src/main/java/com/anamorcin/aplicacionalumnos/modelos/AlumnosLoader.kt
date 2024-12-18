package com.anamorcin.aplicacionalumnos.modelos

fun obtenerAlumnos(): List<Alumno> {
    return listOf(
        Alumno(1,"Laura", 7, true),
        Alumno(2,"Sergio", 4, false),
        Alumno(3,"Eva", 3, false),
        Alumno(4,"Pedro", 8, true),
        Alumno(5,"Sandra", 6, true),
        Alumno(6,"Emilio", 1, false),
        Alumno(7,"Montse", 8, true)
    )
}