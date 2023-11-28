package com.example.demoapp

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.demoapp.data.CommentDatabase

@Suppress("UNCHECKED_CAST")
class CommentsViewModelFactory(private val applicationContext: Context) : ViewModelProvider.Factory {
    private fun createDatabase(): CommentDatabase {
        return Room.databaseBuilder(
            applicationContext,
            CommentDatabase::class.java, "comments_database.db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommentViewModel::class.java)) {
            return CommentViewModel(database = createDatabase()) as T
        }
        throw IllegalArgumentException("Classe ViewModel Desconhecida")
    }
}