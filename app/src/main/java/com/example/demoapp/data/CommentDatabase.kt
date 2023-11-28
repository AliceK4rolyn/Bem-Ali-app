package com.example.demoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ifam.edu.br.pdm.listacompras.data.CommentsDAO
import ifam.edu.br.pdm.listacompras.data.Converters

@Database(entities = [CommentEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CommentDatabase : RoomDatabase() {
    abstract fun commentsDAO(): CommentsDAO
}