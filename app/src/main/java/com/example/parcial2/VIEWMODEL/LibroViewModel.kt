package com.example.parcial2.VIEWMODEL

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial2.MODEL.Libro
import com.example.parcial2.REPOSITORY.LibroRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LibroViewModel(private val libroRepository: LibroRepository) : ViewModel() {

    private val _libros = MutableStateFlow<List<Libro>>(emptyList())
    val libros: StateFlow<List<Libro>> = _libros

    fun loadLibros() {
        viewModelScope.launch {
            _libros.value = libroRepository.getAllLibros()
        }
    }

    fun insertLibro(libro: Libro) {
        viewModelScope.launch {
            libroRepository.insertLibro(libro)
            loadLibros()
        }
    }

    fun updateLibro(libro: Libro) {
        viewModelScope.launch {
            libroRepository.updateLibro(libro)
            loadLibros()
        }
    }

    fun deleteLibro(libro: Libro) {
        viewModelScope.launch {
            libroRepository.deleteLibro(libro)
            loadLibros()
        }
    }
}