package com.example.parcial2.REPOSITORY

import com.example.parcial2.DAO.PrestamoDao
import com.example.parcial2.MODEL.Prestamo

class PrestamoRepository(private val prestamoDao: PrestamoDao) {

    suspend fun insertPrestamo(prestamo: Prestamo) {
        prestamoDao.insertPrestamo(prestamo)
    }

    suspend fun updatePrestamo(prestamo: Prestamo) {
        prestamoDao.updatePrestamo(prestamo)
    }

    suspend fun deletePrestamo(prestamo: Prestamo) {
        prestamoDao.deletePrestamo(prestamo)
    }

    suspend fun getAllPrestamos(): List<Prestamo> {
        return prestamoDao.getAllPrestamos()
    }

    suspend fun getPrestamoById(prestamoId: Int): Prestamo? {
        return prestamoDao.getPrestamoById(prestamoId)
    }
}