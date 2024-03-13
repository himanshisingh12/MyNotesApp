package com.example.mynotesapp.feature_note.domain.util

sealed class NoteSortOrder (val listOrderType: NoteListOrderType) {
    class Title(orderType: NoteListOrderType) : NoteSortOrder(orderType)
    class Date(orderType: NoteListOrderType) : NoteSortOrder(orderType)
    class Color(orderType: NoteListOrderType) : NoteSortOrder(orderType)
}