package com.example.notes.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.notes.data.Repository.NotesRepository
import com.example.notes.data.db.Entity.NoteDatabase
import com.example.notes.data.db.Entity.Notes
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {

    val repository: NotesRepository

    init {
        val dao = NoteDatabase.invoke(application).getNotesDao()
        repository = NotesRepository(dao)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun upsert(item: Notes) =
        GlobalScope.launch {
            repository.upsert(item)
        }

    @OptIn(DelicateCoroutinesApi::class)
    fun delete(item: Notes) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllNotes() = repository.getAllNotes()

}