import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mynic.menulateral.databinding.FragmentProductoRegionBinding
import com.mynic.menulateral.AdapterProducto
import com.mynic.menulateral.Producto
import com.mynic.menulateral.R

class ProductoRegion : Fragment() {

    private var _binding: FragmentProductoRegionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProductoRegionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1) Cargar (o solicitar) la lista de productos
        val products = loadProducts()

        // 2) Crear el adapter con el layout de cada item (cardview_list_item.xml)
        val adapter = AdapterProducto(
            requireContext(),
            resource = R.layout.cardview_list_item, // <-- layout de un solo producto
            products
        )

        // 3) Asignar adapter y opcionalmente listener para clicks
        binding.productListView.apply {
            this.adapter = adapter
            setOnItemClickListener { _, _, position, _ ->
                val clicked = adapter.getItem(position)
                Toast.makeText(
                    requireContext(),
                    "Seleccionaste: ${clicked?.nombre}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Simula la carga de datos.
     * En tu caso, aquí harías la llamada a la base de datos, ViewModel, API, etc.
     */
    private fun loadProducts(): List<Producto> {
        return listOf(
            Producto(
                nombre = "Manzana", precio = 1.20,
                id = TODO(),
                departamento = TODO(),
                ventasTotales = TODO(),
                unidadesVendidas = TODO()
            ),
            Producto(
                nombre = "Banana", precio = 0.80,
                id = TODO(),
                departamento = TODO(),
                ventasTotales = TODO(),
                unidadesVendidas = TODO()
            ),
            Producto(
                nombre = "Cereza", precio = 2.50,
                id = TODO(),
                departamento = TODO(),
                ventasTotales = TODO(),
                unidadesVendidas = TODO()
            ),
            // …más datos reales…
        )
    }
}