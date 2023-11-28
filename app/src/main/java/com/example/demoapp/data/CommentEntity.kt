package com.example.demoapp.data

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.demoapp.CommentModel

@Entity
data class CommentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val comment: String,
) {
    fun toModel(): CommentModel {
        return CommentModel(
            id = this.id,
            comment = this.comment,
        )
    }
}