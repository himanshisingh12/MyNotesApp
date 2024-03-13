package com.example.mynotesapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mynotesapp.ui.theme.BabyBlue
import com.example.mynotesapp.ui.theme.LightGreen
import com.example.mynotesapp.ui.theme.RedOrange
import com.example.mynotesapp.ui.theme.RedPink
import com.example.mynotesapp.ui.theme.Violet

@Entity
data class Note (
    @PrimaryKey val id: Int? = null,
    val title: String,
    val description: String,
    val timestamp: Long,
    val color: Int
) {
    companion object {
        val noteBgColors = listOf(RedOrange, RedPink, Violet, BabyBlue, LightGreen)
    }
}
