package com.mynic.menulateral

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

data class User(val nombre: String, val email: String)

class AdapterUser(
    context: Context,
    private val idRecurso: Int,
    private val usuarios: List<User>
) : ArrayAdapter<User>(context, idRecurso, usuarios) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater
            .from(context)
            .inflate(idRecurso, parent, false)

        val itemActual = getItem(position)
        itemView.findViewById<TextView>(R.id.txtNombre).text = itemActual?.nombre
        itemView.findViewById<TextView>(R.id.txtEmail ).text = itemActual?.email

        return itemView
    }
}
