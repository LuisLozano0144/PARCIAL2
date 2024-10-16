package com.example.parcial2.DAO

import androidx.room.*
import com.example.parcial2.MODEL.Miembro

@Dao
interface MiembroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMiembro(miembro: Miembro)

    @Update
    suspend fun updateMiembro(miembro: Miembro)

    @Delete
    suspend fun deleteMiembro(miembro: Miembro)

    @Query("SELECT * FROM miembros")
    suspend fun getAllMiembros(): List<Miembro>

    @Query("SELECT * FROM miembros WHERE miembro_id = :miembroId")
    suspend fun getMiembroById(miembroId: Int): Miembro?
}