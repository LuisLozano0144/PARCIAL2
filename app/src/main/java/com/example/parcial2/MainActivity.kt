package com.example.parcial2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial2.DAO.MiembroDao
import com.example.parcial2.SCREENS.*
import com.example.parcial2.VIEWMODEL.*
import com.example.parcial2.REPOSITORY.*
import com.example.parcial2.database.AppDatabase
import com.example.parcial2.SCREENS.LibroScreen
import com.example.parcial2.SCREENS.MiembroScreen
import com.example.parcial2.SCREENS.PrestamoScreen
import com.example.parcial2.ui.theme.PARCIAL2Theme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private lateinit var database: AppDatabase // Añadido para la base de datos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicializa la base de datos aquí
        database = AppDatabase.getDatabase(this)

        setContent {
            PARCIAL2Theme {
                navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationGraph(navController, database, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, database: AppDatabase, modifier: Modifier = Modifier) {
    // Creación de DAO a partir de la base de datos
    val miembroDao: MiembroDao = database.miembroDao() // Usa database para acceder a miembroDao
    val libroDao = database.libroDao() // Similar para Libro
    val prestamoDao = database.prestamoDao() // Similar para Préstamo
    val autorDao = database.autorDao() // Similar para Autor

    // Creación de repositorios con el DAO correspondiente
    val miembroRepository = MiembroRepository(miembroDao)
    val libroRepository = LibroRepository(libroDao)
    val prestamoRepository = PrestamoRepository(prestamoDao)
    val autorRepository = AutorRepository(autorDao)

    NavHost(navController = navController, startDestination = "miembros", modifier = modifier) {
        composable("miembros") {
            MiembroScreen(MiembroViewModel(miembroRepository), navController)
        }
        composable("libros") {
            LibroScreen(LibroViewModel(libroRepository), navController)
        }
        composable("prestamos") {
            PrestamoScreen(PrestamoViewModel(prestamoRepository), navController)
        }
        composable("autores") {
            AutorScreen(AutorViewModel(autorRepository), navController)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // Crea una instancia de AppDatabase para acceder a los DAOs
    val database = AppDatabase.getDatabase(LocalContext.current)
    val miembroDao = database.miembroDao() // Obtén el DAO a través de la base de datos
    val miembroRepository = MiembroRepository(miembroDao)

    PARCIAL2Theme {
        MiembroScreen(MiembroViewModel(miembroRepository), rememberNavController())
    }
}

