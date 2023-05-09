package com.example.notes.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notes.data.Repository.NotesRepository

@Suppress("UNCHECKED_CAST")
class NotesViewModelFactory(
    private val repository: NotesRepository,
    val application: Application
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(application) as T
    }
}