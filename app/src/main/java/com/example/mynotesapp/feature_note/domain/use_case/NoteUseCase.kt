package com.example.mynotesapp.feature_note.domain.use_case

data class NoteUseCase(
    val getNotesListUseCase: GetNotesListUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase
)
