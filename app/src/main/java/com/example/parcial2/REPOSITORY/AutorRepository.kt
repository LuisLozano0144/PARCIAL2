package com.example.parcial2.REPOSITORY

import com.example.parcial2.DAO.AutorDao
import com.example.parcial2.MODEL.Autor

class AutorRepository(private val autorDao: AutorDao) {

    suspend fun insertAutor(autor: Autor) {
        autorDao.insertAutor(autor)
    }

    suspend fun updateAutor(autor: Autor) {
        autorDao.updateAutor(autor)
    }

    suspend fun deleteAutor(autor: Autor) {
        autorDao.deleteAutor(autor)
    }

    suspend fun getAllAutores(): List<Autor> {
        return autorDao.getAllAutores()
    }

    suspend fun getAutorById(autorId: Int): Autor? {
        return autorDao.getAutorById(autorId)
    }
}