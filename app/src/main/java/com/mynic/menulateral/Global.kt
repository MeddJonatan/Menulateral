package com.mynic.menulateral

// Modelos de datos
data class Usuario(
    val id: Int,
    val nombre: String,
    val email: String
)

data class Producto(
    val id: Int,
    val nombre: String,
    val departamento: String,
    val ventasTotales: Double,
    val unidadesVendidas: Int,
    val precio: Double
)

data class VentaProducto(
    val nombreProducto: String,
    val totalVentas: Int,
    val unidadesVendidas: Int,
    val periodo: String
)

data class SatisfaccionCliente(
    val region: String,
    val producto: String,
    val satisfaccionPromedio: Double,
    val totalEncuestas: Int,
    val periodo: String
)

// Proveedor de datos simulado
object DataProvider {

    val usuarios = listOf(
        Usuario(1, "Juan López", "jp@yahoo.es"),
        Usuario(2, "María Mendoza", "mm@yahoo.es"),
        Usuario(3, "Óscar Flete", "of@yahoo.es")
    )

    val productos = listOf(
        Producto(1, "Leche", "Managua", 50_000.0, 25_000, 1.20),
        Producto(2, "Yogur", "Masaya", 30_000.0, 15_000, 1.20),
        Producto(3, "Queso", "Granada", 20_000.0, 10_000, 1.20)
    )

    val ventasPorProducto = listOf(
        VentaProducto("Leche", 120_000, 50_000, "2024-Q1"),
        VentaProducto("Yogur", 80_000, 40_000, "2024-Q1"),
        VentaProducto("Queso", 100_000, 45_000, "2024-Q1")
    )

    val satisfaccionClientes = listOf(
        SatisfaccionCliente("Managua", "Leche Descremada", 4.7, 120, "2024-07")
        // Puedes agregar más registros según se necesiten
    )
}

// Ejemplo de uso principal
fun main() {
    // Mostrar todos los usuarios
    println("📋 Lista de usuarios:")
    DataProvider.usuarios.forEach { println("- $it") }

    // Filtrar productos con más de 25,000 unidades vendidas
    val topProductos = DataProvider.productos
        .filter { it.unidadesVendidas > 25_000 }

    println("\n📈 Productos con más de 25,000 unidades vendidas:")
    if (topProductos.isNotEmpty()) {
        topProductos.forEach { println("- ${it.nombre} (${it.unidadesVendidas} unidades)") }
    } else {
        println("Ningún producto superó las 25,000 unidades.")
    }

    // Calcular la venta total del primer trimestre de 2024
    val totalQ1 = DataProvider.ventasPorProducto.sumOf { it.totalVentas }
    println("\n💰 Ventas totales en el período 2024-Q1: $totalQ1 córdobas")
}
