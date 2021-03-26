package com.unicep.app.dogs.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel() {
    private val _tag = "ListViewModel"
    override fun onCleared() {
        super.onCleared()
        Log.d(_tag, "Called :: onCleared()")
    }


    fun makeRandomNumber() : Int {
        return (Math.random()*100).toInt()
    }
}