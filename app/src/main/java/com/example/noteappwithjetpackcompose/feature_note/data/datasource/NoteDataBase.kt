package com.example.noteappwithjetpackcompose.feature_note.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteappwithjetpackcompose.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)

abstract class NoteDataBase:RoomDatabase() {
    abstract val noteDao : NoteDao
    companion object{
        const val DatabaseName="NoteDb"
    }

}