package com.example.mynotesapp.feature_note.domain.util

sealed class NoteListOrderType {
    object Ascending: NoteListOrderType()
    object Descending: NoteListOrderType()
}