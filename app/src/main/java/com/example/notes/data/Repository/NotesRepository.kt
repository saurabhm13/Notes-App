package com.example.notes.data.Repository

import androidx.lifecycle.LiveData
import com.example.notes.data.NotesDao
import com.example.notes.data.db.Entity.NoteDatabase
import com.example.notes.data.db.Entity.Notes

//class NotesRepository(val db: NoteDatabase) {
//
//    suspend fun upsert(item: Notes) = db.getNotesDao().upsert(item)
//
//    suspend fun delete(item: Notes) = db.getNotesDao().delete(item)
//
//    fun getAllNotes() = db.getNotesDao().getAllNotes()
//}

class NotesRepository(val dao: NotesDao){

    fun getAllNotes(): LiveData<List<Notes>>{
        return dao.getAllNotes()
    }

    suspend fun upsert(note: Notes){
        dao.upsert(note)
    }

    suspend fun delete(note: Notes){
        dao.delete(note)
    }
}