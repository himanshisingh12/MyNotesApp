package com.example.mynotesapp.feature_note.domain.use_case

import com.example.mynotesapp.feature_note.domain.model.Note
import com.example.mynotesapp.feature_note.domain.repository.NoteRepository
import com.example.mynotesapp.feature_note.domain.util.NoteListOrderType
import com.example.mynotesapp.feature_note.domain.util.NoteSortOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesListUseCase(private val repository: NoteRepository) {

    operator fun invoke(
        noteSortOrder: NoteSortOrder = NoteSortOrder.Date(NoteListOrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when(noteSortOrder.listOrderType) {
                is NoteListOrderType.Ascending -> {
                    when (noteSortOrder) {
                        is NoteSortOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteSortOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteSortOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is NoteListOrderType.Descending -> {
                    when (noteSortOrder) {
                        is NoteSortOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteSortOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteSortOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}