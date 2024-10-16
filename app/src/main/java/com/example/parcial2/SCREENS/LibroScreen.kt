package com.example.parcial2.SCREENS

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.parcial2.VIEWMODEL.LibroViewModel
import com.example.parcial2.MODEL.Libro
import androidx.compose.foundation.lazy.items

@Composable
fun LibroScreen(libroViewModel: LibroViewModel, navController: NavController) {
    val libros by libroViewModel.libros.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Libros", style = MaterialTheme.typography.titleLarge)

        LazyColumn {
            items(libros) { libro ->
                Text(text = "Título: ${libro.titulo}, Género: ${libro.genero}")
                // Botones para editar y eliminar
                Row {
                    Button(onClick = { /* Lógica para editar */ }) {
                        Text("Editar")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { libroViewModel.deleteLibro(libro) }) {
                        Text("Eliminar")
                    }
                }
            }
        }

        // Formulario para añadir nuevo libro
        var titulo by remember { mutableStateOf("") }
        var genero by remember { mutableStateOf("") }
        var autorId by remember { mutableStateOf("") }

        TextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = genero,
            onValueChange = { genero = it },
            label = { Text("Género") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = autorId,
            onValueChange = { autorId = it },
            label = { Text("ID del Autor") }
        )

        Button(onClick = {
            if (titulo.isNotBlank() && genero.isNotBlank() && autorId.isNotBlank()) {
                libroViewModel.insertLibro(
                    Libro(
                        titulo = titulo,
                        genero = genero, // Asegúrate de pasar el valor de 'genero'
                        autor_id = autorId.toInt()
                    )
                )
                titulo = ""
                genero = ""
                autorId = ""
            }
        }) {
            Text("Añadir Libro")
        }
    }
}
