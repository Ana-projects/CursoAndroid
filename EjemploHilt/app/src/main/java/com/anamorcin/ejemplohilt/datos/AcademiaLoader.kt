package com.anamorcin.ejemplohilt.datos

import javax.inject.Inject

class AcademiaLoader @Inject constructor() {
    fun cargarAlumnos(): List<Alumno> {
        return listOf(
            Alumno(1,"Laura", 7),
            Alumno(2,"Sergio", 4),
            Alumno(3,"Eva", 3),
            Alumno(4,"Pedro", 8),
            Alumno(5,"Sandra", 6),
            Alumno(6,"Emilio", 1),
            Alumno(7,"Montse", 6)
        )
    }
}