package com.example.notes.data.db.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "notes_table")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    var title: String,
    var subTitle: String,
    var note: String,
    var date: String,
    var priority: String
)
