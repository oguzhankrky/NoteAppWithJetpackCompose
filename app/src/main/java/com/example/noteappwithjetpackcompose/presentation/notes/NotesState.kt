package com.example.noteappwithjetpackcompose.presentation.notes

import com.example.noteappwithjetpackcompose.feature_note.domain.model.Note
import com.example.noteappwithjetpackcompose.feature_note.domain.util.NoteOrder
import com.example.noteappwithjetpackcompose.feature_note.domain.util.OrderType

data class NotesState(
    val notes:List<Note> = emptyList(),
    val noteOrder: NoteOrder=NoteOrder.Date(OrderType.Descending),
    val isorderSelectionVisible:Boolean= false

)

