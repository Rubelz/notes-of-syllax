package com.example.notes_of_syllax.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notesTable")
class Note(
    @ColumnInfo(name = "title") val noteTitle: String,
    @ColumnInfo(name = "description") val noteDesc: String,
) {
    @PrimaryKey(autoGenerate = true) var id = 0

}