package com.anamorcin.ejemploroomalumnos.hilt

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.anamorcin.ejemploroomalumnos.datos.AlumnosDao
import com.anamorcin.ejemploroomalumnos.datos.BaseDatosApp
import com.anamorcin.ejemploroomalumnos.datos.RepositorioAlumnos
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideBaseDatosApp(
        @ApplicationContext
        app: Context
    ) = databaseBuilder(
        app,
        BaseDatosApp::class.java,
        "colegio"
    ).build()

    @Singleton
    @Provides
    fun provideAlumnosDao(
        baseDatosApp: BaseDatosApp
    ) = baseDatosApp.alumnoDao()

    @Singleton
    @Provides
    fun provideRepositorioAlumnos(
        alumnosDao: AlumnosDao
    ): RepositorioAlumnos = RepositorioAlumnos(
        alumnosDao = alumnosDao
    )
}