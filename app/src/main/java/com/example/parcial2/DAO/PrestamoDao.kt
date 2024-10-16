package com.example.parcial2.DAO

import androidx.room.*
import com.example.parcial2.MODEL.Prestamo

@Dao
interface PrestamoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrestamo(prestamo: Prestamo)

    @Update
    suspend fun updatePrestamo(prestamo: Prestamo)

    @Delete
    suspend fun deletePrestamo(prestamo: Prestamo)

    @Query("SELECT * FROM prestamos")
    suspend fun getAllPrestamos(): List<Prestamo>

    @Query("SELECT * FROM prestamos WHERE prestamo_id = :prestamoId")
    suspend fun getPrestamoById(prestamoId: Int): Prestamo?
}