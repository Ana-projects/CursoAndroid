package com.anamorcin.ejemploroomalumnos.datos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Alumno::class], version = 1)

abstract class BaseDatosApp : RoomDatabase() {

    abstract fun alumnoDao(): AlumnosDao
}
