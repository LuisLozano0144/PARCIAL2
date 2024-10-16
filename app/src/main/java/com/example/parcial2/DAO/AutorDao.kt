package com.example.parcial2.DAO

import androidx.room.*
import com.example.parcial2.MODEL.Autor

@Dao
interface AutorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAutor(autor: Autor)

    @Update
    suspend fun updateAutor(autor: Autor)

    @Delete
    suspend fun deleteAutor(autor: Autor)

    @Query("SELECT * FROM autores")
    suspend fun getAllAutores(): List<Autor>

    @Query("SELECT * FROM autores WHERE autor_id = :autorId")
    suspend fun getAutorById(autorId: Int): Autor?
}