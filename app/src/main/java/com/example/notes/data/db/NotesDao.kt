package com.example.notes.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.data.db.Entity.Notes

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Notes)

    @Delete
    suspend fun delete(item: Notes)

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): LiveData<List<Notes>>
}