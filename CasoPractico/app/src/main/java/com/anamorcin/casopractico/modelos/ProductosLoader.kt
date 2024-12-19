package com.anamorcin.casopractico.modelos

fun obtenerProductos(): List<Producto> {
    return listOf(
        Producto(1, "CPU Intel Core 9",   110.0, 11),
        Producto(2, "Disco SSD 512 GB", 45.0, 20),
        Producto(3, "Monitor 23", 130.0, 5),
        Producto(4, "Placa base Asus", 75.0, 3),
        Producto(5, "Ratón inalámbrico", 12.0, 12),
        Producto(6, "Teclado inalámbrico", 23.0, 4),
        Producto(7, "Caja Gaming", 86.0, 3),
        Producto(8, "Nvidia RTX 4070", 567.0, 7 ),
        Producto(9, "32 GB RAM DDR 5", 45.0, 6),
    )
}