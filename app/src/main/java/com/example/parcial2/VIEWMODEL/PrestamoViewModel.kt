package com.example.parcial2.VIEWMODEL

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial2.MODEL.Prestamo
import com.example.parcial2.REPOSITORY.PrestamoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PrestamoViewModel(private val prestamoRepository: PrestamoRepository) : ViewModel() {

    private val _prestamos = MutableStateFlow<List<Prestamo>>(emptyList())
    val prestamos: StateFlow<List<Prestamo>> = _prestamos

    fun loadPrestamos() {
        viewModelScope.launch {
            _prestamos.value = prestamoRepository.getAllPrestamos()
        }
    }

    fun insertPrestamo(prestamo: Prestamo) {
        viewModelScope.launch {
            prestamoRepository.insertPrestamo(prestamo)
            loadPrestamos()
        }
    }

    fun updatePrestamo(prestamo: Prestamo) {
        viewModelScope.launch {
            prestamoRepository.updatePrestamo(prestamo)
            loadPrestamos()
        }
    }

    fun deletePrestamo(prestamo: Prestamo) {
        viewModelScope.launch {
            prestamoRepository.deletePrestamo(prestamo)
            loadPrestamos()
        }
    }
}