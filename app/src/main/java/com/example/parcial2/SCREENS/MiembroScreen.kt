package com.example.parcial2.SCREENS

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.parcial2.VIEWMODEL.MiembroViewModel
import com.example.parcial2.MODEL.Miembro

@Composable
fun MiembroScreen(miembroViewModel: MiembroViewModel, navController: NavController) {
    val miembros by miembroViewModel.miembros.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Miembros", style = MaterialTheme.typography.titleLarge)

        LazyColumn {
            items(miembros) { miembro ->
                Text(text = "${miembro.nombre} ${miembro.apellido}")
                // Botones para editar y eliminar
                Row {
                    Button(onClick = { /* Lógica para editar */ }) {
                        Text("Editar")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { miembroViewModel.deleteMiembro(miembro) }) {
                        Text("Eliminar")
                    }
                }
            }
        }

        // Formulario para añadir nuevo miembro
        var nombre by remember { mutableStateOf("") }
        var apellido by remember { mutableStateOf("") }
        var fechaInscripcion by remember { mutableStateOf("") }

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text("Apellido") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = fechaInscripcion,
            onValueChange = { fechaInscripcion = it },
            label = { Text("Fecha de Inscripción (YYYY-MM-DD)") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (nombre.isNotBlank() && apellido.isNotBlank() && fechaInscripcion.isNotBlank()) {
                miembroViewModel.addMiembro(
                    Miembro(
                        nombre = nombre,
                        apellido = apellido,
                        fecha_inscripcion = fechaInscripcion // Se pasa la fecha ingresada por el usuario
                    )
                )
                // Limpiar los campos
                nombre = ""
                apellido = ""
                fechaInscripcion = ""
            }
        }) {
            Text("Añadir Miembro")
        }
    }
}
