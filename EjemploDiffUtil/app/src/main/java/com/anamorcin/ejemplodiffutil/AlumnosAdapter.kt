package com.anamorcin.ejemplodiffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.anamorcin.ejemplodiffutil.modelos.Alumno

class AlumnosAdapter (val alumnos: ArrayList<Alumno>):
    RecyclerView.Adapter<AlumnosAdapter.MiViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.alumno_fila, parent, false)
        return MiViewHolder(view)
    }

    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        val alumno = alumnos[position]
        holder.nombre.text = alumno.nombre
        holder.nota.text = "${alumno.nota}"
    }

    override fun getItemCount(): Int {
        return alumnos.size
    }

    class MiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.nombre)
        val nota: TextView = itemView.findViewById(R.id.nota)
    }

    fun actualizarLista(nuevaLista: List<Alumno>) {
        val diffResult = DiffUtil.calculateDiff(AlumnosDiffCallback(alumnos,
            nuevaLista))
        alumnos.clear()
        alumnos.addAll(nuevaLista)
        diffResult.dispatchUpdatesTo(this)
    }
}

