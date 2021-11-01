package com.example.noteappwithjetpackcompose.di

import android.app.Application
import androidx.room.Room
import com.example.noteappwithjetpackcompose.feature_note.data.datasource.NoteDataBase
import com.example.noteappwithjetpackcompose.feature_note.data.repository.NoteRepositoryImpl
import com.example.noteappwithjetpackcompose.feature_note.domain.repository.NoteRepository
import com.example.noteappwithjetpackcompose.feature_note.domain.usecase.AddNote
import com.example.noteappwithjetpackcompose.feature_note.domain.usecase.DeleteNote
import com.example.noteappwithjetpackcompose.feature_note.domain.usecase.GetNotes
import com.example.noteappwithjetpackcompose.feature_note.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun ProvideNoteDatabase(app:Application):NoteDataBase{
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DatabaseName
        ).build()
    }

    @Provides
    @Singleton
    fun ProvideNoteRepository(db:NoteDataBase):NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun ProvidedNoteUseCases(repository: NoteRepository):NoteUseCases{
            return NoteUseCases(
                getNotes = GetNotes(repository),
                deleteNote= DeleteNote(repository),
                addNote = AddNote(repository )
            )
    }


}