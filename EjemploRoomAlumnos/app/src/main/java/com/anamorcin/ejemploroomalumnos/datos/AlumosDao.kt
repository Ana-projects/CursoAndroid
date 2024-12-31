package com.anamorcin.ejemploroomalumnos.datos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AlumnosDao {
    @Query("SELECT * FROM alumnos")
    fun obtenerAlumnos(): Flow<List<Alumno>>

    @Query("SELECT * FROM alumnos WHERE id = :id")
    fun obtenerAlumno(id: Int): Flow<Alumno>

    @Query("SELECT * FROM alumnos WHERE ciudad = :ciudad")
    fun obtenerAlumnosPorCiudad(ciudad: String): List<Alumno>

    @Query("SELECT * FROM alumnos WHERE calificacion >= 5")
    fun obtenerAlumnosAprobados(): List<Alumno>

    @Query("SELECT * FROM alumnos WHERE calificacion < 5")
    fun obtenerAlumnosSuspensos(): List<Alumno>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertarAlumno(alumnos: Alumno)

    @Update
    fun actualizarAlumno(alumno: Alumno)

    @Delete
    fun eliminarAlumno(alumno: Alumno)

    @Query("DELETE FROM alumnos")
    fun eliminarAlumnos()
}