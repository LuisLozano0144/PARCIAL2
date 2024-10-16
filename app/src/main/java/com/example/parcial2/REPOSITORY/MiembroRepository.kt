package com.example.parcial2.REPOSITORY

import com.example.parcial2.DAO.MiembroDao
import com.example.parcial2.MODEL.Miembro

class MiembroRepository(private val miembroDao: MiembroDao) {

    suspend fun insertMiembro(miembro: Miembro) {
        miembroDao.insertMiembro(miembro)
    }

    suspend fun updateMiembro(miembro: Miembro) {
        miembroDao.updateMiembro(miembro)
    }

    suspend fun deleteMiembro(miembro: Miembro) {
        miembroDao.deleteMiembro(miembro)
    }

    suspend fun getAllMiembros(): List<Miembro> {
        return miembroDao.getAllMiembros()
    }

    suspend fun getMiembroById(miembroId: Int): Miembro? {
        return miembroDao.getMiembroById(miembroId)
    }
}
