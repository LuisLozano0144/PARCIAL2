package com.example.parcial2.REPOSITORY

import com.example.parcial2.DAO.LibroDao
import com.example.parcial2.MODEL.Libro

class LibroRepository(private val libroDao: LibroDao) {

    suspend fun insertLibro(libro: Libro) {
        libroDao.insertLibro(libro)
    }

    suspend fun updateLibro(libro: Libro) {
        libroDao.updateLibro(libro)
    }

    suspend fun deleteLibro(libro: Libro) {
        libroDao.deleteLibro(libro)
    }

    suspend fun getAllLibros(): List<Libro> {
        return libroDao.getAllLibros()
    }

    suspend fun getLibroById(libroId: Int): Libro? {
        return libroDao.getLibroById(libroId)
    }
}