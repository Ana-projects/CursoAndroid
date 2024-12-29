package com.anamorcin.ejemplodiffutil

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.anamorcin.ejemplodiffutil.modelos.Alumno

class AlumnosDiffCallback(private val listaActual: List<Alumno>, private val nuevaLista: List<Alumno>) : DiffUtil.Callback() {
    // Devuelve el tamaño de la lista actual
    override fun getOldListSize() = listaActual.size

    // Devuelve el tamaño de la nueva lista
    override fun getNewListSize() = nuevaLista.size

    /* Aquí escribiremos la lógica para indicar si dos elementos de la lista son los mismos.
        En nuestro caso usamos el id del alumno para ello. */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return listaActual[oldItemPosition].id=== nuevaLista.get(newItemPosition).id
    }

    /* Lo mismo pero para los contenidos de los atributos de alumno.
    Aprovechamos que las data class tienen redefinido el método equals */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }

    @Nullable
    // Este método es opcional y está pensado si usamos animaciones para los cambios
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}