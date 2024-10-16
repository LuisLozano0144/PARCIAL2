package com.example.parcial2.MODEL

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prestamos")
data class Prestamo(
    @PrimaryKey(autoGenerate = true) val prestamo_id: Int = 0,
    val libro_id: Int, // Foreign key
    val miembro_id: Int, // Foreign key
    val fecha_prestamo: String,
    val fecha_devolucion: String
)