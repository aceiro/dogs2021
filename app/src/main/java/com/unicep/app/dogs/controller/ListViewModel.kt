package com.unicep.app.dogs.controller

import android.util.Log
import androidx.lifecycle.ViewModel
import com.unicep.app.dogs.model.Dog

class ListViewModel : ViewModel() {
    private val _tag = "ListViewModel"
    override fun onCleared() {
        super.onCleared()
        Log.d(_tag, "Called :: onCleared()")
    }

    fun loadDogs(): List<Dog> {
        // Método mock que
        // retorna uma lista fixa de itens
        //
        val listOf = listOf(
            Dog(
                name = "Buldogue",
                details = "O buldogue-inglês(em inglês: English Bulldog) é uma raça de cães do tipo buldogue oriunda da Inglaterra",
                imageResId = -1),
            Dog(
                name = "Pastor-alemão",
                details = "O Pastor Alemão tem pelagem áspera.",
                imageResId = -1),
            Dog(
                name = "Poodle",
                details = "Popular, companheiro e peludo. CBKC - Grupo 09 (Toys)",
                imageResId = -1)
        )
        Log.d(_tag, "Called :: loadFakeDogs() $listOf")
        return listOf
    }
}