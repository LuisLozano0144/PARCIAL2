package com.example.parcial2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial2.DAO.MiembroDao
import com.example.parcial2.DAO.LibroDao
import com.example.parcial2.DAO.PrestamoDao
import com.example.parcial2.DAO.AutorDao
import com.example.parcial2.MODEL.Miembro
import com.example.parcial2.MODEL.Libro
import com.example.parcial2.MODEL.Prestamo
import com.example.parcial2.MODEL.Autor

@Database(entities = [Miembro::class, Libro::class, Prestamo::class, Autor::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun miembroDao(): MiembroDao
    abstract fun libroDao(): LibroDao
    abstract fun prestamoDao(): PrestamoDao
    abstract fun autorDao(): AutorDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "nombre_base_datos" // Cambia esto por el nombre que desees
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
