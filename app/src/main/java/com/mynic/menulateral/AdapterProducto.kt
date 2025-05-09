package com.mynic.menulateral

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.mynic.menulateral.databinding.CardviewListItemBinding

class AdapterProducto(
context: Context,
private val resource: Int,
private val productList: List<Producto>
) : ArrayAdapter<Producto>(context, resource, productList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: CardviewListItemBinding
        val itemView: View

        if (convertView == null) {
            binding = CardviewListItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
            itemView = binding.root
            itemView.tag = binding
        } else {
            itemView = convertView
            binding = itemView.tag as CardviewListItemBinding
        }

        // ahora el tipo de getItem() ya es Producto
        getItem(position)?.let { producto ->
            binding.txtProductNameCard.text = producto.nombre
            // ...asigna los demás campos...
        }

        return itemView
    }
}
