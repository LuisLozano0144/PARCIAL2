package com.example.parcial2.VIEWMODEL

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial2.MODEL.Autor
import com.example.parcial2.REPOSITORY.AutorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AutorViewModel(private val autorRepository: AutorRepository) : ViewModel() {

    private val _autores = MutableStateFlow<List<Autor>>(emptyList())
    val autores: StateFlow<List<Autor>> = _autores

    fun loadAutores() {
        viewModelScope.launch {
            _autores.value = autorRepository.getAllAutores()
        }
    }

    fun insertAutor(autor: Autor) {
        viewModelScope.launch {
            autorRepository.insertAutor(autor)
            loadAutores()
        }
    }

    fun updateAutor(autor: Autor) {
        viewModelScope.launch {
            autorRepository.updateAutor(autor)
            loadAutores()
        }
    }

    fun deleteAutor(autor: Autor) {
        viewModelScope.launch {
            autorRepository.deleteAutor(autor)
            loadAutores()
        }
    }
}