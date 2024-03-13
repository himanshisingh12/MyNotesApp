package com.example.mynotesapp.feature_note.presentation.notes_list.components

import androidx.lifecycle.ViewModel
import com.example.mynotesapp.feature_note.domain.use_case.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesListViewModel @Inject constructor (
    private val noteUseCase: NoteUseCase
) : ViewModel() {
}