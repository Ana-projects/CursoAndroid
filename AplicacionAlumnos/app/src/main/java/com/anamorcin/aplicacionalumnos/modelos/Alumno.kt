package com.anamorcin.aplicacionalumnos.modelos

data class Alumno(val id: Int, var nombre: String, var nota: Int,
                  var apto: Boolean = false)
