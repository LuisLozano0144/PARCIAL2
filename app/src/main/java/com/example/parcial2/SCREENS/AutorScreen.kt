package com.example.parcial2.SCREENS

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.parcial2.VIEWMODEL.AutorViewModel
import androidx.compose.foundation.lazy.items
import com.example.parcial2.MODEL.Autor

@Composable
fun AutorScreen(autorViewModel: AutorViewModel, navController: NavController) {
    val autores by autorViewModel.autores.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Autores", style = MaterialTheme.typography.titleLarge)

        LazyColumn {
            items(autores) { autor ->
                Text(text = "${autor.nombre} ${autor.apellido}")
                // Botones para editar y eliminar
                Row {
                    Button(onClick = { /* Lógica para editar */ }) {
                        Text("Editar")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { autorViewModel.deleteAutor(autor) }) {
                        Text("Eliminar")
                    }
                }
            }
        }

        // Formulario para añadir nuevo autor
        var nombre by remember { mutableStateOf("") }
        var apellido by remember { mutableStateOf("") }
        var nacionalidad by remember { mutableStateOf("") }

        // TextField para Nombre
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        // TextField para Apellido
        TextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text("Apellido") }
        )

        // TextField para Nacionalidad
        TextField(
            value = nacionalidad,
            onValueChange = { nacionalidad = it },
            label = { Text("Nacionalidad") }
        )

        Button(onClick = {
            if (nombre.isNotBlank() && apellido.isNotBlank() && nacionalidad.isNotBlank()) {
                autorViewModel.insertAutor(Autor(nombre = nombre, apellido = apellido, nacionalidad = nacionalidad))
                // Limpia los campos
                nombre = ""
                apellido = ""
                nacionalidad = ""
            } else {
                // Mostrar un mensaje de error
            }
        }) {
            Text("Añadir Autor")
        }
    }
}
