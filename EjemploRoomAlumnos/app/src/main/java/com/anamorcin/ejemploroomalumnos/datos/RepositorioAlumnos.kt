package com.anamorcin.ejemploroomalumnos.datos

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositorioAlumnos @Inject constructor(private val alumnosDao: AlumnosDao) {
    fun obtenerAlumnos() = alumnosDao.obtenerAlumnos()

    fun obtenerAlumno(id: Int) = alumnosDao.obtenerAlumno(id)

    fun obtenerAlumposPorCiudad(ciudad: String) =
        alumnosDao.obtenerAlumnosPorCiudad(ciudad)

    fun obtenerAlumnosAprobados() = alumnosDao.obtenerAlumnosAprobados()

    fun obtenerAlumnosSuspensos() = alumnosDao.obtenerAlumnosSuspensos()

    fun insertarAlumno(alumno: Alumno) = alumnosDao.insertarAlumno(alumno)

    fun actualizarAlumno(alumno: Alumno) = alumnosDao.actualizarAlumno(alumno)

    fun eliminarAlumno(alumno: Alumno) = alumnosDao.eliminarAlumno(alumno)

    fun eliminarAlumnos() = alumnosDao.eliminarAlumnos()
}