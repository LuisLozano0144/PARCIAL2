package com.example.parcial2.MODEL

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libros")
data class Libro(
    @PrimaryKey(autoGenerate = true) val libro_id: Int = 0,
    val titulo: String,
    val genero: String,
    val autor_id: Int // Foreign key
)