package com.example.parcial2.DAO

import androidx.room.*
import com.example.parcial2.MODEL.Libro

@Dao
interface LibroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLibro(libro: Libro)

    @Update
    suspend fun updateLibro(libro: Libro)

    @Delete
    suspend fun deleteLibro(libro: Libro)

    @Query("SELECT * FROM libros")
    suspend fun getAllLibros(): List<Libro>

    @Query("SELECT * FROM libros WHERE libro_id = :libroId")
    suspend fun getLibroById(libroId: Int): Libro?
}