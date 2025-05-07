package com.mynic.menulateral

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class AdapterUser( context: Context, idResourse:Int, usuarios: List<User> ):
    ArrayAdapter<User>(context, idResourse, usuarios)
{

        //Para cada elemento de la lista le aplica un diseño de vista
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            //Se crea una vista vacia
            var itemView = convertView
        if (itemView == null) {
            //Se infla la vista con el diseño de la la simplelist
            itemView = LayoutInflater.from(context).inflate(R.layout.simpleitemlist, parent, false)
        }
            //Obtenemos el objeto de la lista
        val ItemActual = getItem(position)

            //Asigamos cada campo del objeto con su respectivo diseño
        itemView!!.findViewById<TextView>(R.id.txtNombre).text= ItemActual?.nombre
        itemView.findViewById<TextView>(R.id.txtemail).text = ItemActual?.email
        return itemView
    }
}