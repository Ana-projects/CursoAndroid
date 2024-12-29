package com.anamorcin.ejemplodiffutil

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anamorcin.ejemplodiffutil.modelos.Alumno
import com.anamorcin.ejemplodiffutil.modelos.obtenerAlumnos

class MainActivity : AppCompatActivity() {
    private lateinit var adaptador: AlumnosAdapter
    private lateinit var alumnos: ArrayList<Alumno>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alumnos = obtenerAlumnos(50)
        val recyclerView = findViewById<RecyclerView>(R.id.alumnosRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adaptador = AlumnosAdapter(alumnos)
        recyclerView.adapter = adaptador
        findViewById<Button>(R.id.ActualizarButton).setOnClickListener {
            val nuevosAlumnos = obtenerAlumnos(20)
            adaptador.actualizarLista(nuevosAlumnos)
        }
    }
}