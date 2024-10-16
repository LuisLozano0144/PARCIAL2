package com.example.parcial2.SCREENS

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.parcial2.VIEWMODEL.PrestamoViewModel
import com.example.parcial2.MODEL.Prestamo
import androidx.compose.foundation.lazy.items

@Composable
fun PrestamoScreen(prestamoViewModel: PrestamoViewModel, navController: NavController) {
    val prestamos by prestamoViewModel.prestamos.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Préstamos", style = MaterialTheme.typography.titleLarge)

        LazyColumn {
            items(prestamos) { prestamo ->
                Text(text = "Libro: ${prestamo.libro_id}, Miembro: ${prestamo.miembro_id}, Fecha Préstamo: ${prestamo.fecha_prestamo}, Fecha Devolución: ${prestamo.fecha_devolucion}")

            // Botones para editar y eliminar
                Row {
                    Button(onClick = { /* Lógica para editar */ }) {
                        Text("Editar")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { prestamoViewModel.deletePrestamo(prestamo) }) {
                        Text("Eliminar")
                    }
                }
            }
        }

        // Formulario para añadir nuevo préstamo
        var libroId by remember { mutableStateOf("") }
        var miembroId by remember { mutableStateOf("") }
        var fecha by remember { mutableStateOf("") }

        TextField(
            value = libroId,
            onValueChange = { libroId = it },
            label = { Text("ID del Libro") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = miembroId,
            onValueChange = { miembroId = it },
            label = { Text("ID del Miembro") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text("Fecha") }
        )

        Button(onClick = {
            if (libroId.isNotBlank() && miembroId.isNotBlank() && fecha.isNotBlank()) {
                prestamoViewModel.insertPrestamo(
                    Prestamo(
                        libro_id = libroId.toInt(),
                        miembro_id = miembroId.toInt(),
                        fecha_prestamo = fecha,
                        fecha_devolucion = ""
                    )
                )
                libroId = ""
                miembroId = ""
                fecha = ""
            }
        }) {
            Text("Añadir Préstamo")
        }

    }
}
