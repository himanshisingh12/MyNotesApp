package com.example.mynotesapp.di

import android.app.Application
import androidx.room.Room
import com.example.mynotesapp.feature_note.data.data_source.NoteDatabase
import com.example.mynotesapp.feature_note.data.repository.NoteRepositoryImpl
import com.example.mynotesapp.feature_note.domain.repository.NoteRepository
import com.example.mynotesapp.feature_note.domain.use_case.DeleteNoteUseCase
import com.example.mynotesapp.feature_note.domain.use_case.GetNotesListUseCase
import com.example.mynotesapp.feature_note.domain.use_case.NoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase (app: Application) : NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase :: class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db:NoteDatabase) : NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCase {
        return NoteUseCase (
            GetNotesListUseCase(repository),
            DeleteNoteUseCase(repository)
        )
    }
}