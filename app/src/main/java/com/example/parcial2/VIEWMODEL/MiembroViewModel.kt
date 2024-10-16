package com.example.parcial2.VIEWMODEL

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial2.MODEL.Miembro
import com.example.parcial2.REPOSITORY.MiembroRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MiembroViewModel(private val miembroRepository: MiembroRepository) : ViewModel() {

    private val _miembros = MutableStateFlow<List<Miembro>>(emptyList())
    val miembros: StateFlow<List<Miembro>> = _miembros

    init {
        loadMiembros() // Cargar los miembros al iniciar
    }

    fun loadMiembros() {
        viewModelScope.launch {
            _miembros.value = miembroRepository.getAllMiembros()
        }
    }

    fun addMiembro(miembro: Miembro) { // Aquí se define el método addMiembro
        viewModelScope.launch {
            miembroRepository.insertMiembro(miembro)
            loadMiembros() // Actualizar la lista después de agregar el nuevo miembro
        }
    }

    fun deleteMiembro(miembro: Miembro) {
        viewModelScope.launch {
            miembroRepository.deleteMiembro(miembro)
            loadMiembros() // Actualizar la lista después de eliminar el miembro
        }
    }

    fun updateMiembro(miembro: Miembro) {
        viewModelScope.launch {
            miembroRepository.updateMiembro(miembro)
            loadMiembros() // Actualizar la lista después de editar el miembro
        }
    }
}
